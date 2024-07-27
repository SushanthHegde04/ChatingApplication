package com.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatapp.model.ChatRoom;

@Repository
public interface ChatRoomRepo extends JpaRepository<ChatRoom,String> {
	  ChatRoom findByChatId(Long chatId);
}
