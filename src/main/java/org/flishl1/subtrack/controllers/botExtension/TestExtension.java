package org.flishl1.subtrack.controllers.botExtension;

import org.flishl1.subtrack.controllers.SubTrackBot;
import org.flishl1.subtrack.enums.bot.CommandAnswer;
import org.flishl1.subtrack.enums.bot.CommandDescription;
import org.flishl1.subtrack.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.abilitybots.api.util.AbilityExtension;

import static org.telegram.telegrambots.abilitybots.api.objects.Locality.USER;
import static org.telegram.telegrambots.abilitybots.api.objects.Privacy.PUBLIC;

@Controller
public class TestExtension implements AbilityExtension {
    @Qualifier("subTrackBotExtension")
    private SubTrackBot subTrackBot;
    private UserService userService;

    public TestExtension(SubTrackBot subTrackBot, UserService userService) {
        this.subTrackBot = subTrackBot;
        this.userService = userService;
        subTrackBot.addExtension(this);
        subTrackBot.onRegister();
    }

    public Ability startCommand() {
        return Ability
                .builder()
                .name("start")
                .info(CommandDescription.START.getValue())
                .locality(USER)
                .privacy(PUBLIC)
                .action(ctx -> {
                    var userInfo = ctx.user();
                    if (userService.existUser(userInfo.getId().toString())){
                        subTrackBot.getSilent().send(CommandAnswer.START_EXIST.getValue(), userInfo.getId());
                    } else {
                        userService.createUser(userInfo);
                        subTrackBot.getSilent().send(CommandAnswer.START_SUCCESSFUL.getValue(), userInfo.getId());
                    }
                })
                .build();
    }
}

