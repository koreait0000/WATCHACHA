package com.spring.wachacha.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {
    @MessageMapping("/hello/{keyword}")
    @SendTo("/topic/greetings/{keyword}")
    public Greeting greeting(HelloMessage message,@PathVariable String keyword) throws Exception {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/chat/{keyword}")
    @SendTo("/topic/chat/{keyword}")
    public Chat chat(Chat chat,@PathVariable String keyword) throws Exception {
        return new Chat(chat.getName(), chat.getMessage());
    }
}
