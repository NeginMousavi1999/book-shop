package tamrin2;

import tamrin2.model.Book;
import tamrin2.service.BookService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Negin Mousavi
 */
public class Main {
    static BookService bookService;

    static {
        try {
            bookService = new BookService();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        List<List<Book>> allBooks = bookService.getAll();
        showWithStars(allBooks);
        System.out.println();
        showWithDashAndPlus(allBooks);
    }

    public static void showWithStars(List<List<Book>> allBooks) {
        System.out.println("********************************************************************" +
                "**************************************************************************");
        for (List<Book> allBook : allBooks) {
            System.out.printf("********************************************************************** %s ***************************************************************"
                    , allBook.get(0).getAuthorName());
            System.out.println();
            allBook.forEach(System.out::println);
            System.out.println("********************************************************************" +
                    "**************************************************************************");
        }
    }

    // گذاشتم که ببینین اینجوری هم پیدا کردم ولی حال نمیکنم باهاش. با همون * بیشتر اوکیم
    public static void showWithDashAndPlus(List<List<Book>> allBooks) {
        System.out.format("+-----------------+----------+----------------+-----------------+----------+---------------+-------------------+%n");
        System.out.format("| Author name     | ISBN     | Book title     | Published year  |  price   |  Soled number | Soled total price |%n");
        for (List<Book> books : allBooks) {
            for (Book book : books) {
                String num = String.valueOf(book.getSoledNumber());
                if (num.length() == 1)
                    num = " " + num;
                System.out.format("+-----------------+----------+----------------+-----------------+----------+---------------+-------------------+%n");
                System.out.printf("|     %s     |%s|      %s     |      %d       | %,.1f |      %s       |     %,.1f     |"
                        , book.getAuthorName(), book.getIsbn(), book.getTitle(), book.getPublishedYear(), book.getPrice()
                        , num, book.getSoledTotalPrice());
                System.out.println();
            }
        }
        System.out.format("+-----------------+----------+----------------+-----------------+----------+---------------+-------------------+%n");
    }
}