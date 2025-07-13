package org.flishl1.subtrack.bot.core;


import jakarta.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.abilitybots.api.util.AbilityExtension;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.Map;

public class SubTrackBot extends AbilityBot {
    private final Integer creatorId;
    private final ApplicationContext context;


    public SubTrackBot(
            TelegramClient telegramClient,
            String botUsername,
            Integer creatorId,
            ApplicationContext context
    ) {
        super(telegramClient, botUsername);
        this.creatorId = creatorId;

        this.context = context;
    }

    @Override
    public long creatorId() {
        return creatorId;
    }

//    @Override
//    public void addExtension(AbilityExtension extension) {
//        super.addExtension(extension);
//    }

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
