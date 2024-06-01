package session12.controller;

import session12.entity.Entity;
import session12.model.GenericDAO;
import session12.model.Model;
import session12.model.ProductDAOImpl;

import java.sql.SQLException;
import java.util.List;

public class Controller<T extends Entity<?>> {
    private Model model = new Model<>();

    public Controller(Model model) throws SQLException {
        this.model = model;
    }

    public void addEntity(Entity entity) throws SQLException, IllegalAccessException {
        model.create(entity);
    }
    public void updateEntity(T entity) throws SQLException {
        model.update(entity);
    }

    public List<T> getAllEntities() throws SQLException {
        List<T> entities = model.getAll();
        return entities;
    }
    public void deleteEntity(T entity) throws SQLException {
    }

    public T getById(int bookId) throws SQLException {
        return (T) model.getById(bookId);
    }
}
