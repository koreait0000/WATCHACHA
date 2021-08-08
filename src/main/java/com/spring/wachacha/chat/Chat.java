package com.spring.wachacha.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Chat {
    private String name;
    private String message;

    public Chat(String name) {
        this.name = name;
    }
}