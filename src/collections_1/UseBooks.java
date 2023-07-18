package collections_1;

public class UseBooks {
  public static void main( String[] args ) {
    Book book1 = new Book( "Harry Potter", "J.K. Rowling", 123456 );
    Book book1_copy = new Book( "Harry Potter", "J.K. Rowling", 123456 );
    Book book2 = new Book( "Lord of the Rings", "J.R.R. Tolkien", 234567 );
    Book book3 = new Book( "The Hobbit", "J.R.R. Tolkien", 345678 );

    if(book1.equals( book1_copy ) ) {
      System.out.println("They are the same book");
      System.out.println(book1.hashCode());
      System.out.println(book1_copy.hashCode());
    } else {
      System.out.println("They are not the same book");
      System.out.println(book1.hashCode());
      System.out.println(book1_copy.hashCode());
    }
  }
}
