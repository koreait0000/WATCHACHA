package com.spring.wachacha.chat;

public class HelloMessage {
    private String name;

    public HelloMessage() {

    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}