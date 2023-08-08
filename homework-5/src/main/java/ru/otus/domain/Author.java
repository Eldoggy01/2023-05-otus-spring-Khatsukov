package ru.otus.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * todo Document type Author
 */
@RequiredArgsConstructor
@Data
public class Author {
    private final long id;
    private final String name;
}
