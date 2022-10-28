package com.example.Coursework_2.Service;

import com.example.Coursework_2.QuestionClass.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface QuestionService {

    Question add(String questions, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestions();


}
