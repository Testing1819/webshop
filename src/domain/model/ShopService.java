package domain.model;

import domain.db.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class ShopService {
    private PersonDbSQL personDb;
    private ProductDbSQL productDb;

    public ShopService(Properties properties){
        try {
            personDb = new PersonDbSQL(properties);
            productDb = new ProductDbSQL(properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Person getUser(int id) {
        return personDb.get(id);
    }

    public Product getProduct(int id) {
        return productDb.get(id);
    }

    public List<Person> getUsers() {
        return personDb.getAll();
    }

    public List<Product> getProducts() {
        return productDb.getAll();
    }

    public int getNrOfProducts() {return productDb.getCount();}

    public void addUser(Person user) {
        personDb.add(user);
    }

    public void addProduct(Product product) {
        productDb.add(product);
    }

    public void updateUser(Person user) {
        personDb.update(user);
    }

    public void updateProduct(Product product) {
        productDb.update(product);
    }

    public void deleteUser(int id) {
        personDb.delete(id);
    }

    public void deleteProduct(int id) {
        productDb.delete(id);
    }

    public boolean containsUser(int id) {
        return personDb.contains(id);
    }

    public boolean containsProduct(int id) {
        return productDb.contains(id);
    }

    public int getNrOfUsers() {return personDb.getCount();}
}
