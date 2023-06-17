package com.example.service;

import com.example.domain.Question;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * todo Document type QuizService
 */

@Service
@AllArgsConstructor
public class QuizService {
    private CsvQuestionReader csvQuestionReader;
    private ClientAnswerReader clientAnswerReader;

    public int checkAnswers() throws IOException {
        List<Question> questions = csvQuestionReader.getQuestionsWithAnswersList();
        Map<Question, String> questionsWithAnswers =  clientAnswerReader.readClientAnswers(questions);

        int correctAnswersCount = 0;

            for (Map.Entry<Question, String> questionsWithAnswer: questionsWithAnswers.entrySet()) {
                if (checkAnswer(questionsWithAnswer.getKey(), questionsWithAnswer.getValue())){
                    correctAnswersCount++;
                }
            }

        return correctAnswersCount;
    }

    private boolean checkAnswer(Question question, String clientsAnswer) {
        return question.trueAnswer().equals(clientsAnswer);
    }

}
