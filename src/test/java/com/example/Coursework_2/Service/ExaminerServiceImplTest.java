package com.example.Coursework_2.Service;

import com.example.Coursework_2.QuestionClass.Question;
import com.example.Exeption.ExeptionQuestions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {


    private static final List<Question> QUESTIONS = List.of(
            new Question("a1", "b1"),
            new Question("a2", "b2"),
            new Question("a3", "b3"),
            new Question("a4", "b4"),
            new Question("a5", "b5")
    );
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    public static Stream<Arguments> getQuestionsParams() {
        return Stream.of(Arguments.of(-1),
                Arguments.of(-1),
                Arguments.of(QUESTIONS.size() + 1));
    }

    @ParameterizedTest
    @MethodSource("getQuestionsParams")
    public void getQuestions(int incorrectAmount) {
        when(questionService.getAll()).thenReturn(QUESTIONS);
        assertThatExceptionOfType(ExeptionQuestions.class)
                .isThrownBy(() -> examinerService.getQuestions(incorrectAmount));
    }

}
