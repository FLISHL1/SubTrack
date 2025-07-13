package org.flishl1.subtrack.bot.core;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.flishl1.subtrack.bot.handler.CommandHandler;
import org.flishl1.subtrack.bot.handler.StartCommandHandler;
import org.flishl1.subtrack.enums.bot.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.abilitybots.api.objects.MessageContext;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class CommandRegistry {
    private final Map<Command, CommandHandler> handlers = new HashMap<>();
    private final StartCommandHandler startCommandHandler;

    public CommandRegistry(StartCommandHandler startCommandHandler) {
        this.startCommandHandler = startCommandHandler;
    }

    @PostConstruct
    public void initHandlers() {
        registerHandler(Command.START, startCommandHandler);
//        registerHandler("/add", new AddSubscriptionHandler(subscriptionService));
//        registerHandler("/list", new ListSubscriptionsHandler(subscriptionService));
    }

    private void registerHandler(Command command, CommandHandler handler) {
        handlers.put(command, handler);
    }

    public void execute(Command command, MessageContext ctx) {
        if (handlers.containsKey(command)) {
            handlers.get(command).handle(ctx);
            log.atInfo().log("Execute command " + command.getValue());
        }
    }
}
