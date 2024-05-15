package com.example.online_school.controller;

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

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/initDbTest.sql")
@Sql("/db/dataDbTest.sql")
class AuthorityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final UUID id = UUID.randomUUID();

    @Test
    void getAuthorityByIdPositiveTest() throws Exception {
        UUID id = UUID.fromString("33663934-6136-3934-2d61-3736382d3439");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/authority/get/{id}", id.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        System.out.println(jsonResponse);



        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains(id.toString()));

    } @Test
    void getAuthorityByIdNegativeTest() throws Exception{

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/authority/get/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(404, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains("This id was not found"));
    }
    }
