package collections_1;

import java.util.Objects;

public class Book {
  private String title;
  private String author;
  private int ISBN;

  public Book( String title, String author, int ISBN ) {
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
  }

  @Override
  public String toString() {
    return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", ISBN=" + ISBN + '}';
  }

  /*@Override
  public boolean equals(Object o) {
    if (o instanceof Book) {
      Book anotherBook = (Book) o;

      return this.ISBN == anotherBook.ISBN;
    }
    return false;
  }*/

 /* @Override
  public int hashCode() {
    return Objects.hash(title, author, ISBN);
  }*/

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return ISBN == book.ISBN && Objects.equals(title, book.title) && Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, ISBN);
  }
}
