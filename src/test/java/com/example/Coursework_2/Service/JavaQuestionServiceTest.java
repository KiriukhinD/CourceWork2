package com.example.Coursework_2.Service;

import com.example.Coursework_2.QuestionClass.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @AfterEach
    public void cleanUp() {
        questionService.getAll().forEach(questionService::remove);
    }

    @Test
    public void add() {
        Question question = new Question("test", "test");
        assertThat(questionService.getAll()).isEmpty();
        questionService.add(question.getQuestion(), question.getAnswer());
        assertThat(questionService.getAll())
                .hasSize(1)
                .containsOnly(question);


    }

    @Test
    public void remove() {
        Question question = new Question("test", "test");
        assertThat(questionService.getAll()).isEmpty();
        questionService.remove(question);
        assertThat(questionService.getAll()).isEmpty();


    }

    @Test
    public void getRandomQuestionsTest() {
        for (int i = 0; i <= 5; i++) {
            add();
        }
        assertThat(questionService.getRandomQuestions());

    }


}
