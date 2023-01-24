package com.example.messagingstompwebsocket.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

import com.example.messagingstompwebsocket.models.Greeting;
import com.example.messagingstompwebsocket.models.HelloMessage;

@Controller
public class GreetingController {
    
    @MessageMapping("/hello")
    @CrossOrigin("*")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

}
