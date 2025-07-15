package org.flishl1.subtrack.bot.handler.command;

import org.telegram.telegrambots.abilitybots.api.objects.MessageContext;

public interface CommandHandler {
    void handle(MessageContext ctx);
}
