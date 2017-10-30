package vo;

/**
 * Created by yahier on 17/7/18.
 */

public class Book {
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String name;
    public String author;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return name.equals(book.name) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + author.hashCode();
    }
}
