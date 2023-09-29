package com.enterprise.commons.ddd.business;

import com.enterprise.commons.ddd.domain.entity.Entity;
import com.enterprise.commons.exception.DomainException;
import com.enterprise.commons.exception.InfrastructureException;
import org.springframework.data.domain.Pageable;

import java.util.Collection;


public interface EntityBusiness<T extends Entity, I> {
    T getById(I id) throws DomainException, InfrastructureException;
    Collection<T> findAll(Pageable pageable) throws DomainException, InfrastructureException;
    void delete(I id) throws DomainException, InfrastructureException;
}
