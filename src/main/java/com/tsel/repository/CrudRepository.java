package com.tsel.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<E extends Serializable, I extends Serializable> {

    Optional<E> findOne(I id);

    List<E> findAll();

    boolean save(E entity);

    boolean delete(E entity);

    long count();
}
