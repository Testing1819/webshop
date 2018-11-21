package domain.db;

import domain.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProductDbSQL extends DbSQL<Product> {

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

            String name = result.getString("name");
            String description = result.getString("description");
            double price = result.getDouble("price");

            return new Product(id, name, description, price);
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
                String name = result.getString("name");
                String description = result.getString("description");
                double price = result.getDouble("price");
                persons.add(new Product(id, name, description, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public void add(Product person) {
        try {
            String sql = "INSERT INTO product VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, person.getId());
            statement.setString(2, person.getName());
            statement.setString(3, person.getDescription());
            statement.setDouble(4, person.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Product person) {
        //
    }
}
