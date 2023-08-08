package ru.otus.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import ru.otus.domain.Author;
import ru.otus.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * todo Document type BookResultSetExtractor
 */
//public class BookResultSetExtractor implements ResultSetExtractor {
//    @Override
//    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
//        Map<Long, Book> students = new HashMap<>();
//        while (rs.next()) {
//            long id = rs.getLong("id");
//            Book student = students.get(id);
//            if (student == null) {
//                student = new Book(id, rs.getString("name"),
//                    new Author(rs.getLong("author_id"), rs.getString("author.name")),
//                    new ArrayList<>(), new ArrayList<>());
//                students.put(student.getId(), student);
//            }
//
//            student.getEmails().add(new EMail(rs.getLong("email_id"),
//                rs.getString("email")));
//        }
//        return students;
//    }
//}
