package org.flishl1.subtrack.controllers;

import org.telegram.telegrambots.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.abilitybots.api.util.AbilityExtension;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class SubTrackBot extends AbilityBot {
    private final Integer creatorId;


    public SubTrackBot(
            TelegramClient telegramClient,
            String botUsername,
            Integer creatorId
    ) {
        super(telegramClient, botUsername);
        this.creatorId = creatorId;
    }

    @Override
    public long creatorId() {
        return creatorId;
    }

    @Override
    public void addExtension(AbilityExtension extension) {
        super.addExtension(extension);
    }

    @Override
    protected String getCommandPrefix() {
        return "/";
    }
}
