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
    public Chat greeting(Chat chat,@PathVariable String keyword) throws Exception {
        return new Chat(HtmlUtils.htmlEscape(chat.getName()) + "님 어서오세요!");
    }

    @MessageMapping("/chat/{keyword}")
    @SendTo("/topic/chat/{keyword}")
    public Chat chat(Chat chat,@PathVariable String keyword) throws Exception {
        return new Chat(chat.getName(), chat.getMessage());
    }
}
