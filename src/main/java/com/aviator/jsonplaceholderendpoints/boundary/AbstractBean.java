package com.aviator.jsonplaceholderendpoints.boundary;

import java.util.List;

public interface AbstractBean<T, ID> {

    T create(T entity);

    T edit(T entity);

    boolean remove(ID id);

    boolean delete(T entity);

    T find(ID id);

    List<T> findAll();

    List<T> findRange(int[] range);

    long count();

}
