package com.caresyntax.scheduling.app;

import com.caresyntax.scheduling.app.controller.ApplicationController;
import com.caresyntax.scheduling.app.model.Patient;
import com.caresyntax.scheduling.app.service.ApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CaresyntaxApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ApplicationService service;

    @Autowired
    ApplicationController controller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void TestAddPatientView() throws Exception {
        this.mvc.perform(get("/patient/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("addPatient"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void viewPatientTest() throws Exception {
        this.mvc.perform(get("/patient/view"))
                .andExpect(status().isOk())
                .andExpect(view().name("patient"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void addPatientTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/patient")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .content(asJsonString(new Patient("firstName2", "lastName2", new Date()))))
                .andExpect(status().isOk())
                .andExpect(view().name("addPatient"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    @Test
    public void deletePatientTest() throws Exception {
        this.mvc.perform(get("/patient/delete/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("patient"))
                .andExpect(model().attribute("patientList", service.getPatientRepository().findAll()))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
