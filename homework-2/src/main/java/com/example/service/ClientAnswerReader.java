package com.example.service;

import com.example.domain.Question;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * todo Document type ClientAnswerReader
 */
@Service
public class ClientAnswerReader {
    public Map<Question, String> readClientAnswers(List<Question> questions) throws IOException {

        Map<Question, String> questionsWithAnswers = new LinkedHashMap<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            for (Question question : questions) {
                System.out.println(question.question());
                questionsWithAnswers.put(question,reader.readLine());
            }
        }
        return questionsWithAnswers;
    }
}
