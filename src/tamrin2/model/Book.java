package tamrin2.model;

import lombok.Data;

/**
 * @author Negin Mousavi
 */
@Data
public class Book implements Comparable<Book>{
    private int id;
    private String isbn;
    private String authorName;
    private String title;
    private int publishedYear;
    private double price;
    private int soledNumber;
    private double soledTotalPrice;

    public Book(int id, String isbn, String authorName, String title, int publishedYear, double price, int soledNumber) {
        this.id = id;
        this.isbn = isbn;
        this.authorName = authorName;
        this.title = title;
        this.publishedYear = publishedYear;
        this.price = price;
        this.soledNumber = soledNumber;
        this.soledTotalPrice = soledNumber * price;
    }

    @Override
    public int compareTo(Book otherBook) {
        return Integer.compare(this.publishedYear, otherBook.publishedYear) * -1;
    }
}
