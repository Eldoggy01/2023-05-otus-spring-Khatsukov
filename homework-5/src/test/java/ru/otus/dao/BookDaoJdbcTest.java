package ru.otus.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.otus.domain.Author;
import ru.otus.domain.Book;
import ru.otus.domain.Genre;

import java.util.List;

/**
 * todo Document type ru.otus.dao.BookDaoJdbcTest
 */
@JdbcTest
@Import(BookDaoJdbc.class)
public class BookDaoJdbcTest {

    @Autowired
    private BookDaoJdbc bookDaoJdbc;

    @DisplayName("возвращать заданную книгу по ее name")
    @Test
    void shouldReturnExpectedBookByName() {
        Book book = bookDaoJdbc.getBook("Good book");
        Assertions.assertEquals("Good book", book.getName());
    }

    @DisplayName("возвращать все книги")
    @Test
    void shouldReturnAllBooks() {
        List<Book> books = bookDaoJdbc.getBooks();
        Assertions.assertEquals(2, books.size());
    }

    @DisplayName("добавление книги")
    @Test
    void shouldAddBook() {
        Book book = new Book(3, "Third book", new Author(1,""), new Genre(1,""));
        bookDaoJdbc.insert(book);
        Assertions.assertEquals(book.getName(), bookDaoJdbc.getBook(3).getName());
    }

    @DisplayName("удаление книги")
    @Test
    void shouldDeleteBook() {
        bookDaoJdbc.getBook(1);
        bookDaoJdbc.deleteById(1);
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> bookDaoJdbc.getBook(1));
    }
}
