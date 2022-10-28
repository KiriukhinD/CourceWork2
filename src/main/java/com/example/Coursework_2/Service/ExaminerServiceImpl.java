package com.example.Coursework_2.Service;

import com.example.Coursework_2.QuestionClass.Question;
import com.example.Exeption.ExeptionQuestions;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new ExeptionQuestions();
        }
        Set<Question> questionSet = new HashSet<>();
        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestions());
        }
        return questionSet;
    }
}
