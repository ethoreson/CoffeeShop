import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class Product {
  private String name;
  private String size;
  private int cost;
  private Timestamp purchased_on;
  private int id;

  public Product(String name, String size, int cost) {
    this.name = name;
    this.size = size;
    this.cost = cost;
  }

  public String getName() {
  return name;
}
  public String getSize() {
  return name;
  }
  public String getCost() {
  return name;
  }
  public Timestamp getPurchased_on() {
  return purchased_on;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object otherProduct){
    if (!(otherProduct instanceof Product)) {
      return false;
    } else {
      Product newProduct = (Product) otherProduct;
      return this.getName().equals(newProduct.getName());
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO products (name, size, cost, purchased_on) VALUES (:name, :size, :cost, now())";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("size", this.size)
        .addParameter("cost", this.cost)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Product> all() {
    String sql = "SELECT * FROM products";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Product.class);
    }
  }

  public static Product find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM products where id=:id";
      Product product = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Product.class);
      return product;
    }
  }

}
