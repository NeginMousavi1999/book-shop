package tamrin2;

import tamrin2.model.Book;
import tamrin2.service.BookService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Negin Mousavi
 */
public class Main {
    //    Scanner scanner = new Scanner(System.in);
    static BookService bookService;

    static {
        try {
            bookService = new BookService();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        List<List<Book>> allBooks = bookService.returnAll();
        for (List<Book> books : allBooks) {
            books.forEach(System.out::println);
            System.out.println("********************************************************************" +
                    "**************************************************************************");
        }
    }
}
