package ru.otus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.dao.BookDaoJdbc;
import ru.otus.domain.Author;
import ru.otus.domain.Book;
import ru.otus.domain.Genre;

import java.util.List;

/**
 * todo Document type BookController
 */
@RequiredArgsConstructor
@ShellComponent
public class BookController {

    private final BookDaoJdbc bookDaoJdbc;

    @ShellMethod("getBook")
    public Book getBook(@ShellOption String name) {
        return bookDaoJdbc.getBook(name);
    }

    @ShellMethod("getBooks")
    public List<Book> getBooks() {
        return bookDaoJdbc.getBooks();
    }

    @ShellMethod("addBook")
    public void addBook(@ShellOption Long id, @ShellOption String name, @ShellOption long authorId, @ShellOption long genreId) {
        Book book = new Book(id, name, new Author(authorId, ""), new Genre(genreId, ""));
        bookDaoJdbc.insert(book);
    }

    @ShellMethod("updateBook")
    public void updateBook(@ShellOption Long id, @ShellOption String name, @ShellOption long authorId, @ShellOption long genreId) {
        Book book = new Book(id, name, new Author(authorId, ""), new Genre(genreId, ""));
        bookDaoJdbc.update(book);
    }

    @ShellMethod("deleteBook")
    public void deleteBook(@ShellOption Long id) {
        bookDaoJdbc.deleteById(id);
    }
}
