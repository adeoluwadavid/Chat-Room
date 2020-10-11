/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webS;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


/**
 *
 * @author Adewole
 */
@Controller
public class ChatController {
    
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message register(@Payload Message msg, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", msg.getSender());
        return msg;
    }
    
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message msg){
        return msg;
    }
}
