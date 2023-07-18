package collections_2;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLists {
  public static void main( String[] args ) {
    LinkedList<String> persons = new LinkedList<>();
    persons.add( "John" );
    persons.add( "Mary" );
    persons.add( "Peter" );
    persons.add( "Mary" );

    System.out.println(persons.size());

    ListIterator<String> iterator = persons.listIterator();
    iterator.next();
    iterator.add( "Jennifer" );

    for( String person: persons ) {
      System.out.println(person);
    }

  }
}
