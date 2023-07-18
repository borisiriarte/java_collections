package collections_2;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList_1 {
  public static void main( String[] args ) {
    LinkedList<String> countries = new LinkedList<>();
    LinkedList<String> cities = new LinkedList<>();

    countries.add( "USA" );
    countries.add( "Canada" );
    countries.add( "Mexico" );
    countries.add( "France" );

    cities.add( "New York" );
    cities.add( "Toronto" );
    cities.add( "Mexico City" );
    cities.add( "Paris" );



    ListIterator<String> iteratorA = countries.listIterator();
    ListIterator<String> iteratorB = cities.listIterator();

    while(iteratorB.hasNext()) {
      if( iteratorA.hasNext() ) {
        iteratorA.next();
      }
      iteratorA.add( iteratorB.next( ));
    }

    System.out.println(countries);
    System.out.println(cities);
    iteratorB = cities.listIterator();

    while(iteratorB.hasNext()) {
      iteratorB.next();
      if( iteratorB.hasNext() ) {
        iteratorB.next();
        iteratorB.remove();
      }
    }
    System.out.println(countries);
    System.out.println(cities);

    countries.removeAll(cities);

    System.out.println(countries);
    System.out.println(cities);
  }
}
