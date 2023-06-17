package com.example.service;

import com.example.domain.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Считывает вопросы из csv файла.
 */
@PropertySource("classpath:application.properties")
@Service
public class CsvQuestionReader {
    @Value("${quizFileName}")
    private String fileName;

    public List<Question> getQuestionsWithAnswersList() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(fileName);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return br.lines()
                .map(
                    it -> {
                        String[] questionAndAnswer = it.split(",");
                        return new Question(questionAndAnswer[0], questionAndAnswer[1]);
                    }
                ).collect(Collectors.toList());
        }
    }
}
