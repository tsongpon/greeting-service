package io.songpon.greetingservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class GreetingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);

    @Value("${name-service.url}")
    private String nameServiceUrl;

    @GetMapping("greeting")
    public String greeting() {
        LOGGER.info("Start send greeting");
        var restClient = RestClient.create();
        var response = restClient.get().uri(nameServiceUrl+"/names").retrieve().toEntity(String.class);
        LOGGER.info("Send greeting message to {}", response.getBody());

        return "Hello " + response.getBody();
    }
}
