package com.ua.springboot.microservice.example.forex.springbootmicroserviceforexservice.controller;

import com.ua.springboot.microservice.example.forex.springbootmicroserviceforexservice.repository.ExchangeValueRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ForexController.class)
public class ForexControllerTestingControllerPartOnly {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExchangeValueRepository repository;

    @Test
    public void retrieveExchangeValue() {
    }

    @Test
    public void greetingShouldReturnDefaultText() throws Exception {
        // when(service.greet()).thenReturn("Hello World");
        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }
}