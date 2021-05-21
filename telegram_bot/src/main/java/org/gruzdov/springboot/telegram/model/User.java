package org.gruzdov.springboot.telegram.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.gruzdov.springboot.telegram.bot.State;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "chat_id",
        name = "users_unique_chatid_idx")})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends AbstractBaseEntity {
    @NotNull
    @Column(name = "chat_id", unique = true, nullable = false)
    private Long chatId;

    @NotBlank
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @NotNull
    @Column(name = "csore", nullable = false)
    private Integer score;

    @NotNull
    @Column(name = "high_score", nullable = false)
    private Integer highScore;

    @NotBlank
    @Column(name = "bot_state", nullable = false)
    private State botState;

    public User(Long chatId) {
        this.chatId = chatId;
        this.name = String.valueOf(chatId);
        this.score = 0;
        this.highScore = 0;
        this.botState = State.START;
    }
}
