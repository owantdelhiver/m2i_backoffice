package com.groupe4.backoffice.dao;

import java.util.List;

public interface GenericDAO<T> {
    int create(T obj);
    List<T> fetchAll();
    T fetchById(Long id);
    void update(T obj);
    void delete(Long id);
}
