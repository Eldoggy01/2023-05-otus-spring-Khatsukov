package ru.otus.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.domain.Author;
import ru.otus.domain.Book;
import ru.otus.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Repository
@RequiredArgsConstructor
public class BookDaoJdbc {
    private final JdbcOperations jdbcOperations;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public List<Book> getBooks() {
        return namedParameterJdbcOperations.query("select * from book left join author on book.author_id = author.id" +
            " left join genre on book.genre_id = genre.id", new BookMapper());
    }

    public Book getBook(String name) {
        Map<String, Object> params = Collections.singletonMap("name", name);
        return namedParameterJdbcOperations.queryForObject(
            "select * from book left join author on book.author_id = author.id " +
                "left join genre on book.genre_id = genre.id  where book.name = :name", params, new BookMapper()

        );
    }

    public Book getBook(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
            "select * from book left join author on book.author_id = author.id " +
                "left join genre on book.genre_id = genre.id where book.id = :id", params, new BookMapper()
        );
    }

    public void update(Book book) {
        namedParameterJdbcOperations.update("update book set name =:name where id =:id)",
            Map.of("id", book.getId(), "name", book.getName()));
    }

    public void insert(Book book) {
        namedParameterJdbcOperations.update("insert into book (id, name, author_id, genre_id)" +
                " values (:id, :name, :authorId, :genreId)",
            Map.of("id", book.getId(), "name", book.getName(), "authorId", book.getAuthor().getId(), "genreId", book.getGenre().getId()));
    }

    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
            "delete from book where id = :id", params
        );
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            long authorId = resultSet.getLong("author_id");
            String authorName = resultSet.getString("author.name");
            long genreId = resultSet.getLong("genre_id");
            String genreName = resultSet.getString("genre.name");
            return new Book(id, name, new Author(authorId, authorName), new Genre(genreId, genreName));
        }
    }
}
