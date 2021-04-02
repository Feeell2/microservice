package com.exercise.microservice.controllers;

import com.exercise.microservice.models.Message;
import com.exercise.microservice.service.MessageService;
import dto.MessageDTO;
import dto.ResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;


@GetMapping("/message")
    public ResponseEntity<List<MessageDTO>> getAllMessage(){
    return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
}
@PostMapping("/message")
    public ResponseEntity<Message> postMessage(@RequestBody Message message){
    return new ResponseEntity<>(messageService.postMessage(message),HttpStatus.OK);
}
}

