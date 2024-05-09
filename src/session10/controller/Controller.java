package session10.controller;

import session10.entities.Entity;
import session10.model.Model;

public class Controller<T extends Entity<?>> {
    private Model<T> model;

    public Controller(Model<T> model) {
        this.model = model;
    }

    public Model<T> getModel() {
        return model;
    }

    public void setModel(Model<T> model) {
        this.model = model;
    }

    public void addEntity(T entity) {

    }
}
