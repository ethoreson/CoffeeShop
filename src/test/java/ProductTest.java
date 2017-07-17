import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void product_instantiatesCorrectly_true() {
    Product testProduct = new Product("Latte", "Grande", 5);
    assertEquals(true, testProduct instanceof Product);
  }

  @Test
  public void getName_productInstantiatesWithName_Latte() {
    Product testProduct = new Product("Latte", "Grande", 5);
    assertEquals("Latte", testProduct.getName());
  }

  @Test
  public void equals_returnsTrueIfNameAndEmailAreSame_true() {
    Product firstProduct = new Product("Latte", "Grande", 5);
    Product anotherProduct = new Product("Latte", "Grande", 5);
    assertTrue(firstProduct.equals(anotherProduct));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Product() {
    Product testProduct = new Product("Latte", "Grande", 5);
    testProduct.save();
    assertTrue(Product.all().get(0).equals(testProduct));
  }

@Test
public void all_returnsAllInstancesOfProduct_true() {
  Product firstProduct = new Product("Latte", "Grande", 5);
  firstProduct.save();
  Product secondProduct = new Product("Cappuchino", "Grande", 5);
  secondProduct.save();
  assertEquals(true, Product.all().get(0).equals(firstProduct));
  assertEquals(true, Product.all().get(1).equals(secondProduct));
}

@Test
public void save_assignsIdToObject() {
  Product testProduct = new Product("Latte", "Grande", 5);
  testProduct.save();
  Product savedProduct = Product.all().get(0);
  assertEquals(testProduct.getId(), savedProduct.getId());
}

@Test
public void find_returnsProductWithSameId_secondProduct() {
  Product firstProduct = new Product("Latte", "Grande", 5);
  firstProduct.save();
  Product secondProduct = new Product("Cappuchino", "Grande", 5);
  secondProduct.save();
  assertEquals(Product.find(secondProduct.getId()), secondProduct);
}

}
