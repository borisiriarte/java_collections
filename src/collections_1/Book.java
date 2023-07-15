package collections_1;

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
}
