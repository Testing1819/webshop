package domain.db;

import domain.model.DatabaseModel;
import domain.model.Person;
import domain.model.Product;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class DbSQL<T extends DatabaseModel> {

    private Properties properties;
    private String tableName;
    String url;

    Connection connection;

    public DbSQL(Properties properties, String tableName) throws SQLException {
        this.tableName = tableName;
        this.properties = properties;
        this.url = properties.getProperty("url");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = DriverManager.getConnection(url, properties);
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

    public void delete(int id) {
        try {
            String sql = "DELETE FROM " + tableName + " WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getCount() {
        try {
            String sql = "SELECT COUNT(*) FROM " + tableName;
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
