package org.flishl1.subtrack.bot.handler.command;

import org.flishl1.subtrack.bot.core.SubTrackBot;
import org.flishl1.subtrack.enums.bot.CommandAnswer;
import org.flishl1.subtrack.model.User;
import org.flishl1.subtrack.service.SubscriptionService;
import org.flishl1.subtrack.service.UserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.abilitybots.api.objects.MessageContext;
import java.text.MessageFormat;


@Component
public class StartCommandHandler implements CommandHandler{
    private final UserService userService;
    private final SubscriptionService subscriptionService;
    private final SubTrackBot bot;

    public StartCommandHandler(UserService userService, SubscriptionService subscriptionService, @Lazy SubTrackBot bot) {
        this.userService = userService;
        this.subscriptionService = subscriptionService;
        this.bot = bot;
    }


    @Override
    public void handle(MessageContext ctx) {
        var userInfo = ctx.user();
        if (userService.existUser(userInfo.getId())){
            User currentUser = userService.getUser(userInfo.getId());
            Long userId = userInfo.getId();
            bot.getSilent().send(
                    MessageFormat.format(
                            CommandAnswer.START_EXIST.getValue(),
                            currentUser.firstName,
                            subscriptionService.getCountSubscription(userId),
                            0 // TODO("Добавить описание")
                            ),
                    userInfo.getId());
        } else {
            userService.createUser(userInfo);
            bot.getSilent().send(CommandAnswer.START_SUCCESSFUL.getValue(), userInfo.getId());
        }
    }
}
