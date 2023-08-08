package ru.otus.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * todo Document type Genre
 */
@RequiredArgsConstructor
@Data
public class Genre {
    private final long id;
    private final String name;
}
