package collections_1;

import java.util.HashSet;
import java.util.Set;

public class UsersAccounts {
  public static void main( String[] args ) {
    Client client1 = new Client( "Juan", 1, 1000 );
    Client client2 = new Client( "Pedro", 2, 2000 );
    Client client3 = new Client( "Maria", 3, 3000 );
    Client client4 = new Client( "Jose", 4, 4000 );
    Client client5 = new Client( "Luis", 5, 5000 );

    Set<Client> bankClients = new HashSet<Client>();

    bankClients.add( client1 );
    bankClients.add( client2 );
    bankClients.add( client3 );
    bankClients.add( client4 );

    for(Client client : bankClients ) {
      System.out.println(client);
    }
  }
}
