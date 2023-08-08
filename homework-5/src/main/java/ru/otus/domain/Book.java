package ru.otus.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * todo Document type Book
 */
@RequiredArgsConstructor
@Data
public class Book {
    private final long id;
    private final String name;
    private final Author author;
    private final Genre genre;
}
