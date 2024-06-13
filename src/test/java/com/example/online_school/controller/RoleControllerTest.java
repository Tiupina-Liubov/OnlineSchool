package com.example.online_school.controller;

import com.example.online_school.entity.Role;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.Set;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/initDbTest.sql")
@Sql("/db/dataDbTest.sql")
@WithMockUser(value = "Admin", password = "111", roles = "ADMIN")
public class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final UUID id = UUID.randomUUID();

    @Test
    void getRoleByIdPositiveTest() throws Exception {
        UUID id = UUID.fromString("35643965-6162-6638-2d30-3834612d3436");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/roles/{id}", id.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains(id.toString()));
    }


    @Test
    void getRoleByIdNegativeTest() throws Exception {

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/roles/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(404, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains(ErrorMessage.ID_NOT_FOUND));
    }

    @Test
    void getRolesPositiveTest() throws Exception {

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/roles/allRoles/")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        System.out.println(jsonResponse);

        Set<Role> roles = objectMapper.readValue(jsonResponse, new TypeReference<>() {});

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertFalse(roles.isEmpty());
    }

}