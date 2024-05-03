package com.example.online_school.controller;

import com.example.online_school.dto.UserAfterCreationDto;
import com.example.online_school.dto.UserCreateDto;
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
import java.util.Date;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("classpath:initDbTest.sql")
@Sql("classpath:dataTest.sql")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createUserPositiveTest() throws Exception {
        UserCreateDto dto=new UserCreateDto("LIubov","Tiupina", LocalDate.of(1993,7,26),"kughti@gmail.com","kikosi","qwerrtyu","+380134567899");
        String json=objectMapper.writeValueAsString(dto);

        MvcResult result= mockMvc
                .perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        String jsonResult=result.getResponse().getContentAsString();
        UserAfterCreationDto userAfterCreationDto=objectMapper.readValue(jsonResult, UserAfterCreationDto.class);

        Assertions.assertEquals(200, result.getResponse().getStatus());
        Assertions.assertEquals(dto.getFirstName(),userAfterCreationDto.getFirstName());

    }

    @Test
    public void createUserNegativeTest() throws Exception {

        UserCreateDto dto = new UserCreateDto("Ivan", "Ivanov", LocalDate.of(1990, 1, 1), "Kolya3@example.com", "ivanuser", "password123", "+380123456789");
        String json = objectMapper.writeValueAsString(dto);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andReturn();

        int status = result.getResponse().getStatus();
        Assertions.assertEquals(409, status);

        String jsonResponse = result.getResponse().getContentAsString();
        Assertions.assertTrue(jsonResponse.contains("The user already exists"));
    }


}
