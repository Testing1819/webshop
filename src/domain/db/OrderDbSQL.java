package domain.db;

import domain.model.Order;
import domain.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderDbSQL extends DbSQL {

    public OrderDbSQL(Properties properties) throws SQLException {
        super(properties, "ordertable");
    }

    public List<Order> getAllFromUser(String username) {
        List<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ordertable WHERE username=? ORDER BY date DESC";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String date = result.getString("date");
                String title = result.getString("title");
                String artist = result.getString("artist");
                double price = result.getDouble("price");
                int amount = result.getInt("amount");

                orders.add(new Order(id, username, date, title, artist, price, amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM ordertable";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String username = result.getString("username");
                String date = result.getString("date");
                String title = result.getString("title");
                String artist = result.getString("artist");
                double price = result.getDouble("price");
                int amount = result.getInt("amount");

                orders.add(new Order(id, username, date, title, artist, price, amount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void add(Order order) {
        try {
            String sql = "INSERT INTO ordertable VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, order.getId());
            statement.setString(2, order.getUsername());
            statement.setString(3, order.getDate());
            statement.setString(4, order.getTitle());
            statement.setString(5, order.getArtist());
            statement.setDouble(6, order.getPrice());
            statement.setInt(7, order.getAmount());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getN(int amount) {
        return null;
    }
}
