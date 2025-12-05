package model.dao;

import java.util.List;

public interface InterfaceDAO<T> {
    public abstract void create(T objeto);
    public abstract T retrieve(int id);
    public abstract List<T> retrieve(String atributo, String valor);
    public abstract void update(T objeto);
    public abstract void delete(T objeto);
    
}
