package org.flishl1.subtrack.bot.handler;

import org.telegram.telegrambots.abilitybots.api.objects.MessageContext;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface CommandHandler {
    void handle(MessageContext ctx);
}
