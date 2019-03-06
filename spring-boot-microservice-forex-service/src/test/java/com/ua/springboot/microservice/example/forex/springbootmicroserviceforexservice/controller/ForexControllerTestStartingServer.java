package com.ua.springboot.microservice.example.forex.springbootmicroserviceforexservice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/* this make all the application to run for testing purpose*/
@RunWith(SpringRunner.class)
/*annotation tells Spring Boot to go and
look for a main configuration class (one with @SpringBootApplication for instance), and use that to start a Spring application context.*/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ForexControllerTestStartingServer {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private ForexController controller;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void retrieveExchangeValue() {
    }

    @Test
    public void greetingShouldReturnDefaultText() {
        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).contains("Hello World");
    }
}