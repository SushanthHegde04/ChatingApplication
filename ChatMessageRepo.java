package com.chatapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatapp.model.ChatMessage;


@Repository
public interface ChatMessageRepo extends JpaRepository<ChatMessage, Long> {
    Optional<ChatMessage> findById(Long id);
}
