package com.example.producer.controller;

import com.example.producer.dto.UserCreate;
import com.example.producer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProducerController {

    private final KafkaProducerService producerService;

    @Autowired
    public ProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public void publishMessage(@RequestBody UserCreate message) {
        producerService.sendMessage(message);
    }
}

