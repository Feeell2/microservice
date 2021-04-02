package com.exercise.microservice.service;

import com.exercise.microservice.exceptions.MessageNotFoundException;
import com.exercise.microservice.models.Message;
import com.exercise.microservice.repository.MessageRepository;
import dto.MessageDTO;
import dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<MessageDTO> getAllMessages() {
        log.info("*** getAllMessages()");
        return messageRepository.findAll()
                .stream()
                .map(this::convertToMessageDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public Message postMessage(Message message) {
        log.info("*** createMessage() UIID: " + message.getId() + "content: " + message.getContent());
        messageRepository.save(message);

        return message;
    }

    @Transactional
    public Message updateMessage(UUID id, String content) throws MessageNotFoundException {
        log.info("updateMessage()");
        Message message = messageRepository.findById(id).orElseThrow(() -> new MessageNotFoundException(id));
        message.setContent(content);
        return messageRepository.save(message);
    }

    private MessageDTO convertToMessageDTO(Message user) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        MessageDTO messageDTO = modelMapper
                .map(user, MessageDTO.class);
        return messageDTO;
    }



}
