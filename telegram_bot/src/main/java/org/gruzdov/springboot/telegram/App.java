package org.gruzdov.springboot.telegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        // Здесь код написан по заветам
        // https://github.com/rubenlagus/TelegramBots/tree/master/telegrambots-spring-boot-starter
        //ApiContextInitializer.init();

        SpringApplication.run(App.class, args);
    }
}