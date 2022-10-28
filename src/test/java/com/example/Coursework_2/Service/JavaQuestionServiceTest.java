package com.example.Coursework_2.Service;

import com.example.Coursework_2.QuestionClass.Question;
import com.example.Exeption.ExeptionQuestions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @AfterEach
    public void cleanUp() {
        questionService.getAll().forEach(questionService::remove);
    }

    @Test
    public void addPozitivTest() {
        Question question = new Question("test", "test");
        Question question1 = new Question("test2", "test2");
        assertThat(questionService.getAll()).isEmpty();
        questionService.add(question.getQuestion(), question.getAnswer());
        assertThat(questionService.getAll())
                .hasSize(1)
                .containsOnly(question);
        questionService.add(question1);
        assertThat(questionService.getAll())
                .hasSize(2)
                .containsOnly(question, question1);

    }

    @Test
    public void addNegativTest() {
        Question question = new Question("test", "test");
        assertThat(questionService.getAll()).isEmpty();
        questionService.add(question.getQuestion(), question.getAnswer());
        assertThatExceptionOfType(ExeptionQuestions.class)
                .isThrownBy(() -> questionService.add(question));


    }

    @Test
    public void removePositivTest() {
        Question question = new Question("test", "test");
        assertThatExceptionOfType(ExeptionQuestions.class)
                .isThrownBy(() -> questionService.remove(question));
        questionService.add(question);

        assertThatExceptionOfType(ExeptionQuestions.class)
                .isThrownBy(() -> questionService.remove(new Question("test", " test")));

    }

    @Test
    public void removeNegativTest() {
        Question question = new Question("test", "test");
        assertThat(questionService.getAll()).isEmpty();
        questionService.add(question);
        questionService.remove(question);
        assertThat(questionService.getAll()).isEmpty();


    }

    @Test
    public void getRandomQuestionPozitivTest() {
        for (int i = 0; i <= 5; i++) {
            questionService.add(new Question("q" + i, "a " + i));
        }

        assertThat(questionService.getRandomQuestions()).isIn(questionService.getAll());

    }

    @Test
    public void getRandomQuestionNegativTest() {
        assertThat(questionService.getAll().isEmpty());
        assertThat(questionService.getRandomQuestions()).isIn(questionService.getAll());

    }


}
