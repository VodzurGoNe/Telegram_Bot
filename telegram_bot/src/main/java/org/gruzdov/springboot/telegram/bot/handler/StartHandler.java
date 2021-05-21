package org.gruzdov.springboot.telegram.bot.handler;

import org.gruzdov.springboot.telegram.bot.State;
import org.gruzdov.springboot.telegram.model.User;
import org.gruzdov.springboot.telegram.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static org.gruzdov.springboot.telegram.util.TelegramUtil.createMessageTemplate;

@Component
public class StartHandler implements Handler {
    @Value("${bot.name}")
    private String botUserName;

    private final JpaUserRepository userRepository;

    public StartHandler(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<PartialBotApiMethod<? extends Serializable>> handle(User user, String message) {
        SendMessage welcomeMessage = createMessageTemplate(user);
        welcomeMessage.setText(String.format("Hola! I'm *%s*%nI am here to help you learn Java", botUserName));
        SendMessage registrationMessage = createMessageTemplate(user);
        welcomeMessage.setText("In order to start our journey tell me your name");
        // Меняем пользователю статус на - "ожидание ввода имени"
        user.setBotState(State.ENTER_NAME);
        userRepository.save(user);
        return List.of(welcomeMessage, registrationMessage);
    }

    @Override
    public State operatedBotState() {
        return State.START;
    }

    @Override
    public List<String> operatedCallBackQuery() {
        return Collections.emptyList();
    }
}
