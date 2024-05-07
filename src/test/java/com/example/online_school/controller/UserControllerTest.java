package com.example.online_school.controller;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.entity.User;
import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.errorMassage.ErrorMassage;
import com.example.online_school.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(value = "/db/initDbTest.sql")
@Sql(value = "/db/dataDbTest.sql")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    private final UUID id = UUID.randomUUID();


    @Test
    public void createUserPositiveTest() throws Exception, ObjectAlreadyExistsException {
        UserCreateDto dto = new UserCreateDto("Liubov", "Tiupina", LocalDate.of(1993, 7, 26), "kughti@gmail.com", "kikosi", "qwerrtyu", "+380134567899");
        String json = objectMapper.writeValueAsString(dto);
        UserAfterCreationDto userAfterCreationDto=new UserAfterCreationDto();

        when(userService.createUser(any(UserCreateDto.class))).thenReturn(userAfterCreationDto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        UserAfterCreationDto afterCreationDto = objectMapper.readValue(jsonResult, UserAfterCreationDto.class);

        Assertions.assertEquals(200, result.getResponse().getStatus());
    }

//    @Test
//    public void createUserNegativeTest() throws Exception {
//
//        UserCreateDto dto = new UserCreateDto("Ivan", "Ivanov", LocalDate.of(1990, 1, 1), "Kolya3@example.com", "ivanuser", "password123", "+380123456789");
//        String json = objectMapper.writeValueAsString(dto);
//
//
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andReturn();
//
//        int status = result.getResponse().getStatus();
//        Assertions.assertEquals(409, status);
//
//        String jsonResponse = result.getResponse().getContentAsString();
//        Assertions.assertTrue(jsonResponse.contains("The user already exists"));
//    }

    @Test
    public void getUserPositiveTest() throws Exception {
        User mockUser = new User(id, "Liubov", "Tiupina");
        when(userService.getUserById(id)).thenReturn(mockUser);

        String json = objectMapper.writeValueAsString(mockUser);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(json))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertEquals(json, result.getResponse().getContentAsString());
    }

    @Test
    public void getUserNegativeTest() throws Exception {
        when(userService.getUserById(id)).thenThrow(new IdNotFoundException(ErrorMassage.ID_NOT_FOUND));

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(409, result.getResponse().getStatus());
        Assertions.assertEquals(jsonResponse, result.getResponse().getContentAsString());

    }
}
