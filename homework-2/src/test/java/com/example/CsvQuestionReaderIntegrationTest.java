package com.example;

import com.example.domain.Question;
import com.example.service.CsvQuestionReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { CsvQuestionReader.class })
class CsvQuestionReaderIntegrationTest {

    @Autowired
    private CsvQuestionReader reader;

    @Test
    void testReader() throws IOException {
      List<Question> list =  reader.getQuestionsWithAnswersList();
        assertEquals(2, list.size());
    }
}
