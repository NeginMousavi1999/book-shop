package tamrin2.dao;

import tamrin2.model.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Negin Mousavi
 */
public class BookDao extends BaseDao {
    public BookDao() throws ClassNotFoundException, SQLException {
    }

    public List<String> getAuthorsName() throws SQLException {
        List<String> names = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT `author-name` FROM books;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                names.add(resultSet.getString(1));
        }
        return names;
    }

    public List<Book> findBooksByAuthorName(String authorName) throws SQLException {
        List<Book> books = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM books WHERE `author-name` = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, authorName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                books.add(create(resultSet));
        }
        return books;
    }

    private Book create(ResultSet resultSet) throws SQLException {
        return new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6),
                resultSet.getInt(7));
    }
}
