package org.flishl1.subtrack.config;

import org.flishl1.subtrack.controllers.SubTrackBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Configuration
public class TelegramBotConfig {
    @Value("${bot.telegram_api}")
    private String telegramApi;
    @Value("${bot.telegram_bot_name}")
    private String botUsername;
    @Value("${bot.telegram_creator_id}")
    private Integer creatorId;

    @Bean
    public SubTrackBot subTrackBot() {

        TelegramBotsLongPollingApplication botApplication = telegramBotsLongPollingApplication();
        try {
            SubTrackBot subTrackBot = new SubTrackBot(
                    new OkHttpTelegramClient(telegramApi),
                    botUsername,
                    creatorId
            );
            subTrackBot.onRegister();
            botApplication.registerBot(telegramApi, subTrackBot);
            return subTrackBot;
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public TelegramBotsLongPollingApplication telegramBotsLongPollingApplication() {
        return new TelegramBotsLongPollingApplication();
    }
}
