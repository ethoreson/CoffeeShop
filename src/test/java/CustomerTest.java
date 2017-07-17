import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class CustomerTest {

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

}
