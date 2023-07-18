package collections_1;

import java.util.Objects;

public class Client {
  private String name;
  private int id;
  private double balance;

  public Client( String name, int id, double balance ) {
    this.name = name;
    this.id = id;
    this.balance = balance;
  }

  public String getName() {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId( int id ) {
    this.id = id;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance( double balance ) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "collections_1.Cliente: " + "\nname: '" + name + "\nid: " + id + "\nbalance: " + balance + "\n----------";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Client client = (Client) o;
    return id == client.id && Double.compare(client.balance, balance) == 0 && Objects.equals(name, client.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, balance);
  }
}
