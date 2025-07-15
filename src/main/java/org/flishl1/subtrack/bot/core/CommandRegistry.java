package org.flishl1.subtrack.bot.core;

import jakarta.annotation.PostConstruct;
import org.flishl1.subtrack.bot.handler.command.CommandHandler;
import org.flishl1.subtrack.bot.handler.command.StartCommandHandler;
import org.flishl1.subtrack.enums.bot.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.abilitybots.api.objects.MessageContext;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandRegistry {

    private static final Logger log = LoggerFactory.getLogger(CommandRegistry.class);
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
