package com.chatapp.service;

import org.springframework.stereotype.Service;

import com.chatapp.model.ChatMessage;

 @Service
public class ChatService {

    public ChatMessage save(ChatMessage chatMessage) {
        // Save message logic
        return chatMessage;
    }
} 
