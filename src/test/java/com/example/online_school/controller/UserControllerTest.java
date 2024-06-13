package com.example.online_school.controller;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserAfterUpdateDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.dto.UserUpdateDto;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/initDbTest.sql")
@Sql("/db/dataDbTest.sql")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final UUID id = UUID.randomUUID();

    @Test
    @WithAnonymousUser
    public void createUserPositiveTest() throws Exception{
        UserCreateDto dto = new UserCreateDto("Liubov", "Tiupina", LocalDate.of(1993, 7,
                26), "kughti@gmail.com", "kikosi", "Qwerru!2", "+380134567899");
        String json = objectMapper.writeValueAsString(dto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        UserAfterCreationDto userAfterCreationDto;
        userAfterCreationDto = objectMapper.readValue(jsonResult, UserAfterCreationDto.class);

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertNotNull(userAfterCreationDto.getId());
        Assertions.assertEquals("USER CREATED", userAfterCreationDto.status);
    }

    @Test
    @WithAnonymousUser
    public void createUserNegativeTest() throws Exception {
        UserCreateDto dto = new UserCreateDto("Ivan", "Ivanov",
                LocalDate.of(1990, 1, 1), "Kolya3@example.com", "Ivanuser1",
                "Hpassword123!", "+380123456789");

        String json = objectMapper.writeValueAsString(dto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(409, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains("The user already exists"));
    }

    @Test
    @WithMockUser(value = "User", password = "111", roles = "USER")
    public void getUserPositiveTest() throws Exception {
        UUID id = UUID.fromString("34373438-3761-3263-2d37-3966312d3432");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", id.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains(id.toString()));
    }

    @Test
    @WithMockUser(value = "User", password = "111", roles = "USER")
    public void getUserNegativeTest() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(404, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains("This id was not found"));
    }

    @Test
    @WithMockUser(value = "User", password = "111", roles = "USER")
    void deleteUserByIDPositiveTest() throws Exception {
        UUID id = UUID.fromString("64323334-6439-3964-2d31-3730652d3432");

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.delete("/users/delete/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertEquals(jsonResponse, "*****DELETE****");
    }

    @Test
    @WithMockUser(value = "User", password = "111", roles = "USER")
    void deleteUserByIDNegativeTest() throws Exception {

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.delete("/users/delete/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(404, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains(ErrorMessage.ID_NOT_FOUND));
    }

    @Test
    @WithMockUser(value = "User", password = "111", roles = "USER")
    void updateUserPositiveTest() throws Exception {
        UUID id = UUID.fromString("34373438-3761-3263-2d37-3966312d3432");
        UserUpdateDto dto = new UserUpdateDto("Ivan", "Ivanov", null, "", "", "", "+380971799154");
        String json = objectMapper.writeValueAsString(dto);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.put("/users/update/{id}/", id.toString(), json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        System.out.println(jsonResponse);

        UserAfterUpdateDto userAfterUpdateDto = objectMapper.readValue(jsonResponse, UserAfterUpdateDto.class);
        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertNotNull(userAfterUpdateDto.getId());
        Assertions.assertEquals("User data update", userAfterUpdateDto.getStatus());
    }

    @Test
    @WithMockUser(value = "User", password = "111", roles = "USER")
    void updateUserNegativeTest() throws Exception {
        UserUpdateDto dto = new UserUpdateDto("Ivan", "Ivanov", null, "", "", "", "+380971799154");
        String json = objectMapper.writeValueAsString(dto);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.put("/users/update/{id}/", id.toString(), json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        System.out.println(jsonResponse);

        Assertions.assertEquals(404, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains("This id was not found"));
    }
}
