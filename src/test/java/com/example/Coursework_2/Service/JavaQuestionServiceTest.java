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
        assertThat(questionService.getAll()).isEmpty();
        Question question = new Question("test", "test");
        questionService.add(question.getQuestion(), question.getAnswer());
        assertThat(questionService.getAll())
                .hasSize(1)
                .containsOnly(question);


    }


}
