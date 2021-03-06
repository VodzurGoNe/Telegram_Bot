package org.gruzdov.springboot.telegram.bot.handler;

import org.gruzdov.springboot.telegram.bot.State;
import org.gruzdov.springboot.telegram.model.User;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static org.gruzdov.springboot.telegram.bot.handler.RegistrationHandler.NAME_CHANGE;
import static org.gruzdov.springboot.telegram.util.TelegramUtil.createInlineKeyboardButton;
import static org.gruzdov.springboot.telegram.util.TelegramUtil.createMessageTemplate;

@Component
public class HelpHandler implements Handler {

    @Override
    public List<PartialBotApiMethod<? extends Serializable>> handle(User user, String message) {
        // Create button to change name
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> inlineKeyboardButtonsRowOne = List.of(createInlineKeyboardButton(
                "Change name", NAME_CHANGE));
        inlineKeyboardMarkup.setKeyboard(List.of(inlineKeyboardButtonsRowOne));
        SendMessage sendMessage = createMessageTemplate(user);
        sendMessage.setText(String.format("" + "You've asked for help %s? Here it comes!", user.getName()));
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return List.of(sendMessage);
    }

    @Override
    public State operatedBotState() {
        return State.NONE;
    }

    @Override
    public List<String> operatedCallBackQuery() {
        return Collections.emptyList();
    }
}