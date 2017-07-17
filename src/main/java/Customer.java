public class Customer {
  private String name;

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
  return name;
}

  @Override
  public boolean equals(Object otherCustomer){
    if (!(otherCustomer instanceof Customer)) {
      return false;
    } else {
      Customer newCustomer = (Customer) otherCustomer;
      return this.getName().equals(newCustomer.getName());
    }
  }


}
