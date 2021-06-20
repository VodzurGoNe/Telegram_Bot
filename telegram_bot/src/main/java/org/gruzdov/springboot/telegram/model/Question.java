package org.gruzdov.springboot.telegram.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "java_quiz")
public class Question extends AbstractBaseEntity {
    @NotBlank
    @Column(name = "question", nullable = false)
    private String question;

    @NotBlank
    @Column(name = "answer_correct", nullable = false)
    private String correctAnswer;

    @NotBlank
    @Column(name = "option2", nullable = false)
    private String optionOne;

    @NotBlank
    @Column(name = "option1", nullable = false)
    private String optionTwo;

    @NotBlank
    @Column(name = "option3", nullable = false)
    private String optionThree;
}
