package collections_1;

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
}
