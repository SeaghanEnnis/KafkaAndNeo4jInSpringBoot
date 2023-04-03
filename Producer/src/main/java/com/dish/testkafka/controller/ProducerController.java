package com.dish.testkafka.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produce")
public class ProducerController {

    @Autowired
    KafkaTemplate<String, String> template;


    @PostMapping("/message")
    public String getTestData(@RequestBody String message) {

        CompletableFuture<SendResult<String, String>> future = template.send("topic1", message);

        future.whenComplete((result, ex) -> {
            
        });

        return "done";
    }
    
}
