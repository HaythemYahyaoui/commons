package com.enterprise.commons.ddd.repository;

import com.enterprise.commons.ddd.domain.entity.Entity;
import com.enterprise.commons.exception.DomainException;
import com.enterprise.commons.exception.InfrastructureException;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;


public interface EntityRepository<T extends Entity<I>, I> {

    T getById(I id) throws InfrastructureException;

    T save(T entity) throws InfrastructureException;

    void delete(I id) throws InfrastructureException;

    void update(T entity) throws InfrastructureException;

    Collection<T> findAll(Pageable pageable) throws InfrastructureException;

}
