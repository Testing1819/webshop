package domain.db;

import domain.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersonDbSQL extends DbSQL<Person> {

    public PersonDbSQL(Properties properties) throws SQLException {
        super(properties, "person");
    }

    public Person get(int id) {
        try {
            String sql = "SELECT * FROM person WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();

            String email = result.getString("email");
            String password = result.getString("password");
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");

            return new Person(id, email, password, firstName, lastName);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        try {
            String sql = "SELECT * FROM person";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Integer id = result.getInt("id");
                String email = result.getString("email");
                String password = result.getString("password");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                persons.add(new Person(id, email, password, firstName, lastName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public void add(Person person) {
        try {
            String sql = "INSERT INTO person VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, person.getId());
            statement.setString(2, person.getEmail());
            statement.setString(3, person.getPassword());
            statement.setString(4, person.getFirstName());
            statement.setString(5, person.getLastName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Person person) {
        //
    }
}
