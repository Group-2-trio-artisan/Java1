package session12.model;

import session12.entity.Entity;

import java.sql.SQLException;
import java.util.List;

public interface ModelDAO<T extends Entity<?>> {
    void create(T entity) throws SQLException, IllegalAccessException;
    T getById(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    void update(T entity) throws SQLException;
    boolean delete(int id) throws SQLException;
}
