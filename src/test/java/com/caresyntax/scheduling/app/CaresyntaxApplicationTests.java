package com.caresyntax.scheduling.app;

import com.caresyntax.scheduling.app.controller.ApplicationController;
import com.caresyntax.scheduling.app.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(ApplicationController.class)
public class CaresyntaxApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ApplicationService service;

    @Test
    public void contextLoads() {
    }

    
}
