package tamrin2.service;

import tamrin2.dao.BookDao;
import tamrin2.model.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Negin Mousavi
 */
public class BookService {
    BookDao bookDao = new BookDao();

    public BookService() throws SQLException, ClassNotFoundException {
    }

    public List<String> getAllAuthorsName() throws SQLException {
        return bookDao.getAuthorsName();
    }

    public List<Book> getAllBooksByAuthorNameSortedByPublishedYear(String authorName) throws SQLException {
        List<Book> books = bookDao.findBooksByAuthorName(authorName);
        return sortBooksByPublishedYear(books);
    }

    public List<Book> sortBooksByPublishedYear(List<Book> books) {
        Collections.sort(books);
        return books;
    }

    public List<List<Book>> returnAll() throws SQLException {//TODO must be rename
        List<List<Book>> books = new ArrayList<>();
        List<String> names = getAllAuthorsName();
        for (String name : names)
            books.add(getAllBooksByAuthorNameSortedByPublishedYear(name));

        return books;
    }
}
