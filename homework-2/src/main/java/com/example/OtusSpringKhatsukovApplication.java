package com.example;

import com.example.service.QuizService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.IOException;

public class OtusSpringKhatsukovApplication {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        QuizService quizService = context.getBean(QuizService.class);
        int result = quizService.checkAnswers();
        System.out.println("Number of correct answers: " + result);
    }
}