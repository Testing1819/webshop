package domain.db;

import domain.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDbSQL extends DbSQL {

    public ProductDbSQL(Properties properties) throws SQLException {
        super(properties, "product");
    }

    public Product get(int id) {
        try {
            String sql = "SELECT * FROM product WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();

            String title = result.getString("title");
            String description = result.getString("description");
            double price = result.getDouble("price");
            String type = result.getString("type");
            String genre = result.getString("genre");
            String artist = result.getString("artist");

            return new Product(id, title, artist, description, genre, type, price);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> getAll() {
        List<Product> persons = new ArrayList<>();
        try {
            String sql = "SELECT * FROM product";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String description = result.getString("description");
                double price = result.getDouble("price");
                String type = result.getString("type");
                String genre = result.getString("genre");
                String artist = result.getString("artist");

                persons.add(new Product(id, title, artist, description, genre, type, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public void add(Product product) {
        try {
            String sql = "INSERT INTO product VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, product.getId());
            statement.setString(2, product.getTitle());
            statement.setString(3, product.getDescription());
            statement.setDouble(4, product.getPrice());
            statement.setString(5, product.getType());
            statement.setString(6, product.getGenre());
            statement.setString(7, product.getArtist());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Product product) {
        try {
            String sql = "UPDATE " + tableName + " SET username=?, email=?, password=?, firstName=?, lastName=?, role=? WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, product.getId());
            statement.setString(2, product.getTitle());
            statement.setString(3, product.getDescription());
            statement.setDouble(4, product.getPrice());
            statement.setString(5, product.getType());
            statement.setString(6, product.getGenre());
            statement.setString(7, product.getArtist());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM product WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean contains(int id) {
        try {
            String sql = "SELECT COUNT(1) FROM " + tableName + " WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt(1)==1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Product> getN(int amount) {
        List<Product> persons = new ArrayList<>();
        try {
            String sql = "SELECT * FROM product LIMIT ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, amount);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String description = result.getString("description");
                double price = result.getDouble("price");
                String type = result.getString("type");
                String genre = result.getString("genre");
                String artist = result.getString("artist");

                persons.add(new Product(id, title, artist, description, genre, type, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
