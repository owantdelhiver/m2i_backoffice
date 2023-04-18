package com.groupe4.backoffice.dao;

import java.util.List;

public interface GenericDAO<T> {
    boolean create();
    List<T> fetchAll();
    T fetchById(Long id);
    void update(T obj);
    void delete(T obj);
}
