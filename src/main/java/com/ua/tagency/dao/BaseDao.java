package com.ua.tagency.dao;

import java.util.List;

public interface BaseDao<T, D> {
    T findById(D id);
    void save(T t);
    void deleteById(D id);
    List<T> findAll();
    void update(T t);
}
