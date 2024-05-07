package com.example.online_school.controller;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.handler.ErrorExtension;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(value = "/db/initDbTest.sql")
@Sql(value = "/db/dataDbTest.sql")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    private final UUID id = UUID.randomUUID();


    @Test
    public void createUserPositiveTest() throws Exception, ObjectAlreadyExistsException {
        UserCreateDto dto = new UserCreateDto("Liubov", "Tiupina", LocalDate.of(1993, 7, 26), "kughti@gmail.com", "kikosi", "qwerrtyu", "+380134567899");
        String json = objectMapper.writeValueAsString(dto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        System.out.println(jsonResult);
        UserAfterCreationDto userAfterCreationDto;
        userAfterCreationDto = objectMapper.readValue(jsonResult, UserAfterCreationDto.class);

        assertEquals(200, result.getResponse().getStatus());
        Assertions.assertNotNull(userAfterCreationDto.getId());


    }

    @Test
    public void createUserNegativeTest() throws Exception {

        UserCreateDto dto = new UserCreateDto("Ivan", "Ivanov",
                LocalDate.of(1990, 1, 1), "Kolya3@example.com", "ivanuser",
                "password123", "+380123456789");

        String json = objectMapper.writeValueAsString(dto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        int status = result.getResponse().getStatus();

        assertEquals(409, status);


        String jsonResponse = result.getResponse().getContentAsString();
        ErrorExtension errorExtension = objectMapper.readValue(jsonResponse, ErrorExtension.class);
        assertEquals("The user already exists", errorExtension.getMessage());
    }

//    @Test
//    public void getUserPositiveTest() throws Exception {
//        UUID id = UUID.fromString("14a59ac9-8681-432b-a770-7893b52b6e6e");
//        User user = new User();
//        user.setId(id);
//        String json = objectMapper.writeValueAsString(user);
//
//
//     MvcResult result=   mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", id.toString())
//                        .accept(MediaType.APPLICATION_JSON))
//             .andExpect(content().json(json))
//             .andReturn();
//
//        String jsonResponse = result.getResponse().getContentAsString();
//        assertEquals(200, result.getResponse().getStatus());
//        assertEquals(jsonResponse, result.getResponse().getContentAsString());
//    }
//
    @Test
    public void getUserNegativeTest() throws Exception {

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(404, result.getResponse().getStatus());
        Assertions.assertEquals(jsonResponse, result.getResponse().getContentAsString());

    }
}
