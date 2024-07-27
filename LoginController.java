package com.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.model.ChatRoom;
import com.chatapp.model.User;
import com.chatapp.repository.ChatRoomRepo;
import com.chatapp.repository.UserRepository;

@RestController
@RequestMapping("/")
public class LoginController {
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private ChatRoomRepo chatRoomRepository;

	    @PostMapping("/login")
	    
	    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password, @RequestParam Long chatId) {
	        User user = userRepository.findByUsername(username);
	        
	        if (user == null) {
	            return ResponseEntity.badRequest().body("Invalid username");
	        }
	        
	        if (!user.getPassword().equals(password)) {
	            return ResponseEntity.badRequest().body("Invalid password");
	        }
	        
	        ChatRoom chatRoom = chatRoomRepository.findByChatId(chatId);
	        
	        if (chatRoom == null) {
	            chatRoom = new ChatRoom(chatId, "New Chat Room");
	            chatRoomRepository.save(chatRoom);
	        }
	        
	        if (user.getChatRoom() == null || !user.getChatRoom().equals(chatRoom)) {
	            user.setChatRoom(chatRoom);
	            userRepository.save(user);
	        }

	        
	        return ResponseEntity.ok("User added to chat room");
	   
   }
}
