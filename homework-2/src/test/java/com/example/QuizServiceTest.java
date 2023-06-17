package com.example;

import com.example.domain.Question;
import com.example.service.ClientAnswerReader;
import com.example.service.CsvQuestionReader;
import com.example.service.QuizService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * todo Document type CsvQuestionReaderTest
 */
@ExtendWith(MockitoExtension.class)
public class QuizServiceTest {

    @Mock
    private CsvQuestionReader csvQuestionReader;

    @Mock
    private ClientAnswerReader clientAnswerReader;

    @Test
    void testQuizService() throws IOException {
        List<Question> questions = Arrays.asList(
            new Question("How many seconds in 2 minutes?", "120"),
            new Question("How many minutes in 3 hours?", "180")
        );

        when(csvQuestionReader.getQuestionsWithAnswersList()).thenReturn(questions);

        when(clientAnswerReader.readClientAnswers(questions)).thenReturn(
            questions.stream().collect(Collectors.toMap(question -> question, question -> "120")
            ));

        QuizService quizService = new QuizService(csvQuestionReader, clientAnswerReader);
        int actualResult = quizService.checkAnswers();
        assertEquals(1, actualResult);
    }
}
