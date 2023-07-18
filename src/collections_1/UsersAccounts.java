package collections_1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UsersAccounts {
  public static void main( String[] args ) {
    Client client1 = new Client( "Juan", 1, 1000 );
    Client client2 = new Client( "Pedro", 2, 2000 );
    Client client3 = new Client( "Maria", 3, 3000 );
    Client client4 = new Client( "Jose", 4, 4000 );
    Client client5 = new Client( "Juan", 1, 1000 );

    Set<Client> bankClients = new HashSet<>();

    bankClients.add( client1 );
    bankClients.add( client2 );
    bankClients.add( client3 );
    bankClients.add( client4 );
    bankClients.add( client5 );

    Iterator<Client> iterator = bankClients.iterator();

    while( iterator.hasNext() ) {
      Client client = iterator.next();
      if ( client.getName().equals( "Juan" ) ) {
        iterator.remove();
      }
    }

    for ( Client client : bankClients ) {
      System.out.println(client.toString());
    }

    /*for(Client client : bankClients ) {
      *//*System.out.println(client.toString());*//*
      if ( client.getName().equals( "Juan" ) ) {
          bankClients.remove(client);
      }
    }*/

    /*Iterator<Client> iterator = bankClient  s.iterator();

    while( iterator.hasNext() ) {
      Client client = iterator.next();
        System.out.println(client.toString());
    }*/
  }
}
