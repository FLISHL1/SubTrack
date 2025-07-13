package org.flishl1.subtrack.bot.extension;

import org.flishl1.subtrack.bot.core.CommandRegistry;
import org.flishl1.subtrack.enums.bot.Command;
import org.flishl1.subtrack.enums.bot.CommandDescription;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.abilitybots.api.util.AbilityExtension;

import static org.telegram.telegrambots.abilitybots.api.objects.Locality.USER;
import static org.telegram.telegrambots.abilitybots.api.objects.Privacy.PUBLIC;

@Controller
public class BaseExtension implements AbilityExtension {
    private final CommandRegistry commandRegistry;

    public BaseExtension(CommandRegistry commandRegistry) {
        this.commandRegistry = commandRegistry;
    }

    public Ability startCommand() {
        return Ability
                .builder()
                .name(Command.START.getValue())
                .info(CommandDescription.START.getValue())
                .locality(USER)
                .privacy(PUBLIC)
                .action(ctx -> commandRegistry.execute(Command.START, ctx))
                .build();
    }
}

