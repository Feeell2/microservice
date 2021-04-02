package com.exercise.microservice.repository;

import com.exercise.microservice.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {

}
