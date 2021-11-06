package tamrin2.service;

import tamrin2.dao.BookDao;
import tamrin2.model.Book;

import java.sql.SQLException;
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

    public List<Book> getAllBooksByAuthorName(String authorName) throws SQLException {
        return bookDao.findBooksByAuthorName(authorName);
    }
}
