package collections_3;

import java.util.HashMap;
import java.util.Map;

public class Maps {
  public static void main( String[] args ) {
    HashMap<String, Employee > staff = new HashMap<>();
    staff.put("141", new Employee("John"));
    staff.put("142", new Employee("Jane"));
    staff.put("143", new Employee("Jack"));
    staff.put("144", new Employee("Jill"));

    System.out.println(staff);

    staff.remove( "144" );

    System.out.println(staff);

    staff.put( "143", new Employee("Carlos") );
    System.out.println(staff);

    /*System.out.println(staff.entrySet());*/

    for( Map.Entry<String, Employee > entry: staff.entrySet() ) {
      String key = entry.getKey();
      Employee value = entry.getValue();

      System.out.println(key + " => " + value);
    }

  }
}

class Employee {
  private String name;
  private double salary;

  public Employee( String name) {
    this.name = name;
    this.salary = 2000;
  }

  @Override
  public String toString() {
    return "employee:" + "\n{\nname: "+ name + "\nsalary: " + salary + "\n}\n";
  }
}
