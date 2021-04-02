package com.exercise.microservice.validators;

import com.exercise.microservice.models.Message;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MessageValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Message.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Message message=(Message) o;
        if(checkInputString(message.getContent())){
            errors.rejectValue("message","message.empty");
        }
    }
    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
