package domain.db;

import domain.model.Product;
import domain.model.Role;
import domain.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDbSQL extends DbSQL {

    public UserDbSQL(Properties properties) throws SQLException {
        super(properties, "person");
    }

    public boolean contains(String username) {
        try {
            String sql = "SELECT COUNT(1) FROM " + tableName + " WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt(1)==1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void delete(String username) {
        try {
            String sql = "DELETE FROM " + tableName + " WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User get(String username) {
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String email = result.getString("email");
                String password = result.getString("password");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String role = result.getString("role");

                return new User(username, email, password, firstName, lastName, Role.valueOf(role));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + tableName;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String username = result.getString("username");
                String email = result.getString("email");
                String password = result.getString("password");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String role = result.getString("role");

                users.add(new User(username, email, password, firstName, lastName, Role.valueOf(role)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void add(User user) {
        try {
            String sql = "INSERT INTO " + tableName + " VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {
        try {
            String sql = "UPDATE " + tableName + " SET username=?, email=?, password=?, firstName=?, lastName=?, role=? WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getRole());
            statement.setString(7, user.getUsername());
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
