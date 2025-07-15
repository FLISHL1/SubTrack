package org.flishl1.subtrack.bot.core;


import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.abilitybots.api.objects.Reply;
import org.telegram.telegrambots.abilitybots.api.util.AbilityExtension;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.Map;
import java.util.function.Consumer;

public class SubTrackBot extends AbilityBot {
    private final Integer creatorId;
    private final ApplicationContext context;


    public SubTrackBot(
            TelegramClient telegramClient,
            String botUsername,
            Integer creatorId,
            ApplicationContext context
    ) {
        super(telegramClient, botUsername, new PostgresDBContext());
        this.creatorId = creatorId;

        this.context = context;
    }

    @Override
    public long creatorId() {
        return creatorId;
    }


    @PostConstruct
    public void registerExtensions() {
        Map<String, AbilityExtension> extensions = context.getBeansOfType(AbilityExtension.class);
        extensions.values().forEach(this::addExtension);
        this.onRegister();
    }
    @Override
    protected String getCommandPrefix() {
        return "/";
    }


}
