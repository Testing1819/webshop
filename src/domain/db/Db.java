package domain.db;

import domain.model.DatabaseModel;
import domain.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface Db<T extends DatabaseModel> {
    boolean contains(int id);

    T get(int id);

    List<T> getAll();

    void add(T record);

    void update(T record);

    void delete(int id);

    int getCount();
}
