/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webS;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 *
 * @author Adewole
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    //Since websocket fails to identify a particular user, STOMP is required.
    // To establish a connection with our Websocket server.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws").withSockJS();
        //.setAllowedOrigins("mydomian.com")
    }
    // The method is used to route the message from one client to another.
    // */app* and */topic* are called destinations
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/topic");
      
    }
}
