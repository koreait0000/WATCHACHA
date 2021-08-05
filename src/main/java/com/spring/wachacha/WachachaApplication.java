package com.spring.wachacha;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class WachachaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WachachaApplication.class, args);
        log.info("@ChatController, chat GET()");
    }

}
