import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class CustomerTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void customer_instantiatesCorrectly_true() {
    Customer testCustomer = new Customer("Sowmya");
    assertEquals(true, testCustomer instanceof Customer);
  }

  @Test
  public void getName_customerInstantiatesWithName_Henry() {
    Customer testCustomer = new Customer("Henry");
    assertEquals("Henry", testCustomer.getName());
  }

  @Test
  public void equals_returnsTrueIfNameAndEmailAreSame_true() {
    Customer firstCustomer = new Customer("Henry");
    Customer anotherCustomer = new Customer("Henry");
    assertTrue(firstCustomer.equals(anotherCustomer));
  }

  @Test
public void save_insertsObjectIntoDatabase_Customer() {
  Customer testCustomer = new Customer("Henry");
  testCustomer.save();
  assertTrue(Customer.all().get(0).equals(testCustomer));
}

@Test
public void all_returnsAllInstancesOfCustomer_true() {
  Customer firstCustomer = new Customer("Henry");
  firstCustomer.save();
  Customer secondCustomer = new Customer("Harriet");
  secondCustomer.save();
  assertEquals(true, Customer.all().get(0).equals(firstCustomer));
  assertEquals(true, Customer.all().get(1).equals(secondCustomer));
}

@Test
public void save_assignsIdToObject() {
  Customer testCustomer = new Customer("Henry");
  testCustomer.save();
  Customer savedCustomer = Customer.all().get(0);
  assertEquals(testCustomer.getId(), savedCustomer.getId());
}

@Test
public void find_returnsCustomerWithSameId_secondCustomer() {
  Customer firstCustomer = new Customer("Henry");
  firstCustomer.save();
  Customer secondCustomer = new Customer("Harriet");
  secondCustomer.save();
  assertEquals(Customer.find(secondCustomer.getId()), secondCustomer);
}

}
