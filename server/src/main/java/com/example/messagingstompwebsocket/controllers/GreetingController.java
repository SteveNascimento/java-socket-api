package com.example.messagingstompwebsocket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.example.messagingstompwebsocket.models.Greeting;
import com.example.messagingstompwebsocket.models.HelloMessage;

@Controller
@RestController
public class GreetingController {

    private SimpMessagingTemplate template;

    @Autowired
    public GreetingController(SimpMessagingTemplate template) {
        this.template = template;
    }
    
    @MessageMapping("/hello")
    @CrossOrigin("*")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @CrossOrigin("*")
    @PostMapping("/app/teste")
    public void greet(@RequestBody HelloMessage hello) {
        Greeting greet = new Greeting(hello.getName());
        this.template.convertAndSend("/topic/greetings", greet);
    }

}
