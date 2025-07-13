package org.flishl1.subtrack.bot.handler;

import org.flishl1.subtrack.bot.core.SubTrackBot;
import org.flishl1.subtrack.enums.bot.CommandAnswer;
import org.flishl1.subtrack.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.abilitybots.api.objects.MessageContext;

@Component
public class StartCommandHandler implements CommandHandler{
    private final UserService userService;
    private final SubTrackBot bot;

    public StartCommandHandler(UserService userService, @Lazy SubTrackBot bot) {
        this.userService = userService;
        this.bot = bot;
    }


    @Override
    public void handle(MessageContext ctx) {
        var userInfo = ctx.user();
        if (userService.existUser(userInfo.getId().toString())){
            bot.getSilent().send(CommandAnswer.START_EXIST.getValue(), userInfo.getId());
        } else {
            userService.createUser(userInfo);
            bot.getSilent().send(CommandAnswer.START_SUCCESSFUL.getValue(), userInfo.getId());
        }
    }
}
