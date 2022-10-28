package com.example.Coursework_2.Service;

import com.example.Coursework_2.QuestionClass.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
