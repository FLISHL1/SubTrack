package org.flishl1.subtrack;

import org.flishl1.subtrack.controllers.SubTrackBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

@SpringBootApplication
public class SubTrackApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubTrackApplication.class, args);
    }

}
