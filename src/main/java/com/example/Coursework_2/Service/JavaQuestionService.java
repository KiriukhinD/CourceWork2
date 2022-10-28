package com.example.Coursework_2.Service;

import com.example.Coursework_2.QuestionClass.Question;
import com.example.Exeption.ExeptionQuestions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Random random = new Random();
    Set<Question> questions = new HashSet<>();

    public Question add(String questions, String answer) {
        return add(new Question(questions, answer));
    }

    public Question add(Question question) {
        if (questions.add(question)) {
            throw new ExeptionQuestions();
        }
        return question;
    }

    public Question remove(Question question) {
        if (questions.remove(question)) {
            throw new ExeptionQuestions();
        }
        return question;

    }

    public Collection<Question> getAll() {

        return new HashSet<>(questions);
    }

    public Question getRandomQuestions() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }


}
