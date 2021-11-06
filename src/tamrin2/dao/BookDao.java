package tamrin2.dao;

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
}
