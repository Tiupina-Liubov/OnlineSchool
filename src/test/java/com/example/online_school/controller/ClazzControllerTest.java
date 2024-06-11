package com.example.online_school.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/initDbTest.sql")
@Sql("/db/dataDbTest.sql")
@WithMockUser(value = "Student", password = "111", roles = "STUDENT")
class ClazzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final UUID id = UUID.randomUUID();


    @Test
    void getClassByIdPositiveTest() throws Exception {
        UUID id = UUID.fromString("66363533-3130-3164-2d36-6666652d3433");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/class/{id}", id.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        System.out.println(jsonResponse);

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains(id.toString()));
    }

    @Test
    void getClassByIdNegativeTest() throws Exception {

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/class/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(404, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains("This id was not found"));
    }

}