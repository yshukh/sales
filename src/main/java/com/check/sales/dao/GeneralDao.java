package com.check.sales.dao;

import java.util.List;

public interface GeneralDao<T> {

    void save(T t);

    List<T> get();

    void update(T t);

    void delete(T t);

}
