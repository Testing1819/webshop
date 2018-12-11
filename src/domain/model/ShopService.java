package domain.model;

import domain.db.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class ShopService {
    private UserDbSQL userDb;
    private ProductDbSQL productDb;
    private OrderDbSQL orderDb;

    public ShopService(Properties properties){
        try {
            userDb = new UserDbSQL(properties);
            productDb = new ProductDbSQL(properties);
            orderDb = new OrderDbSQL(properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String username) {
        return userDb.get(username);
    }

    public User getUserIfAuthenticated(String username, String password) {
        User user = userDb.get(username);
        if (user != null) {
            if (user.isPasswordCorrect(password)) {
                return user;
            }
        }
        return null;
    }

    public void addOrder(Order order) {
        orderDb.add(order);
    }

    public List<Order> getOrdersFromUser(String username) { return orderDb.getAllFromUser(username);}

    public List<Order> getOrders() {return orderDb.getAll();}

    public Product getProduct(int id) {
        return productDb.get(id);
    }

    public List<User> getUsers() {
        return userDb.getAll();
    }

    public List<Product> getProducts() {
        return productDb.getAll();
    }

    public List<Product> getProducts(int amount) {
        return productDb.getN(amount);
    }

    public int getNrOfProducts() {return productDb.getCount();}

    public void addUser(User user) {
        userDb.add(user);
    }

    public void addProduct(Product product) {
        productDb.add(product);
    }

    public void updateUser(User user) {
        userDb.update(user);
    }

    public void updateProduct(Product product) {
        productDb.update(product);
    }

    public void deleteUser(String username) {
        userDb.delete(username);
    }

    public void deleteProduct(int id) {
        productDb.delete(id);
    }

    public boolean containsUser(String username) {
        return userDb.contains(username);
    }

    public boolean containsProduct(int id) {
        return productDb.contains(id);
    }

    public int getNrOfUsers() {return userDb.getCount();}

    public int getNrOfOrders() { return orderDb.getCount(); }
}
