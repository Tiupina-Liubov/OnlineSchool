package com.example.online_school.controller;

import com.example.online_school.dto.UserInfoAfterCreationDto;
import com.example.online_school.dto.UserInfoCreateDto;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@Nested
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/initDbTest.sql")
@Sql("/db/dataDbTest.sql")
 public class UserInfoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final UUID id = UUID.randomUUID();


    @Test
    void getUserInfoByIdPositiveTest() throws Exception {
        UUID id =UUID.fromString("61313464-6330-3062-2d65-3937662d3465");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user_infos/get/{id}", id.toString())
                        .param("id", id.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains("61313464-6330-3062-2d65-3937662d3465"));
    }

    @Test
    void getUserInfoByIdNegativeTest() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/user_infos/get/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(404, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains(ErrorMessage.ID_NOT_FOUND));
    }

    @Test
    void createUserInfoPositiveTest() throws Exception {
        UserInfoCreateDto dto = new UserInfoCreateDto("Titotova193@gmail.com", "Titova19", "gugKtigmai46m", "+380134567899");
        String json = objectMapper.writeValueAsString(dto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user_infos/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        String jsonResult = result.getResponse().getContentAsString();
        UserInfoAfterCreationDto userInfoAfterCreationDto;
        userInfoAfterCreationDto = objectMapper.readValue(jsonResult, UserInfoAfterCreationDto.class);

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertNotNull(userInfoAfterCreationDto.getId());
        Assertions.assertEquals("USER INFO CREATED",userInfoAfterCreationDto.status);
    }

    @Test
    void createUserInfoNegativeTest() throws Exception {

        UserInfoCreateDto dto = new UserInfoCreateDto("LENA2@meta.ua", "Titova19", "gugKtigmai46m", "+380134567899");
        String json = objectMapper.writeValueAsString(dto);

        MvcResult result =  mockMvc.perform(MockMvcRequestBuilders.post("/user_infos/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(409, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains(ErrorMessage.USER_ALREADY_EXISTS));
    }

    @Test
    void updateUserInfo() {
    }
}