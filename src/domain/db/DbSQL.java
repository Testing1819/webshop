package domain.db;

import domain.model.Product;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public abstract class DbSQL {

    private Properties properties;
    protected String tableName;
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

    public abstract List<Product> getN(int amount);
}
