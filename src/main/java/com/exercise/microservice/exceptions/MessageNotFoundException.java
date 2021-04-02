package com.exercise.microservice.exceptions;

import java.util.UUID;

public class MessageNotFoundException extends Exception {
    private UUID messageUUID;

    public MessageNotFoundException(UUID messageUUID) {
        super("Message is not found with UUID : " + messageUUID.toString());
    }
}
