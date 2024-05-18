package com.example.online_school.controller;

import com.example.online_school.entity.Role;
import com.example.online_school.exception.ObjectNotFoundException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import com.example.online_school.service.RoleService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/db/initDbTest.sql")
@Sql("/db/dataDbTest.sql")
public class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private final UUID id = UUID.randomUUID();

    @Test
    void getRoleByIdPositiveTest() throws Exception {
        UUID id = UUID.fromString("35643965-6162-6638-2d30-3834612d3436");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/roles/get/{id}", id.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains(id.toString()));

    }


    @Test
    void getRoleByIdNegativeTest() throws Exception {

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/roles/get/{id}", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();

        Assertions.assertEquals(404, result.getResponse().getStatus());
        Assertions.assertTrue(jsonResponse.contains(ErrorMessage.ID_NOT_FOUND));
    }

    @Test
    void getRolesPositiveTest() throws Exception {

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/roles/allRoles/", id.toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        System.out.println(jsonResponse);

        List<Role> roles = objectMapper.readValue(jsonResponse, new TypeReference<>() {
        });

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertFalse(roles.isEmpty());

    }

//    @Test
//    void getRolesNegativeTest() throws Exception {
//
//        RoleService roleService = Mockito.mock(RoleService.class);
//
//        when(roleService.getAllRoles()).thenThrow(new ObjectNotFoundException(ErrorMessage.ROLES_NOT_FOUND));
//
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/roles/allRoles/")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//
//        String jsonResponse = result.getResponse().getContentAsString();
//        System.out.println(jsonResponse);
//
//        Assertions.assertEquals(404, result.getResponse().getStatus());
//        Assertions.assertTrue(jsonResponse.contains(ErrorMessage.ROLES_NOT_FOUND));
//
//    }// todo НЕ выходит вызвать исключение надо подумать как сделать это

    @Test
    void deleteRoleByID() {



    }

    @Test
    void createRole() {
    }

    @Test
    void getRolesByUserName() {
    }
}