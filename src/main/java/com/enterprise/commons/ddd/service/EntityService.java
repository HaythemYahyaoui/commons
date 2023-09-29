package com.enterprise.commons.ddd.service;

import com.enterprise.commons.ddd.domain.entity.Entity;
import com.enterprise.commons.exception.DomainException;
import com.enterprise.commons.exception.InfrastructureException;
import com.enterprise.commons.exception.PresentationException;
import org.springframework.data.domain.Pageable;

import java.util.Collection;


public interface EntityService<T extends Entity, I> {

    T getById(I id) throws PresentationException, DomainException, InfrastructureException;
    Collection<T> findAll(Pageable pageable) throws PresentationException, DomainException, InfrastructureException;
    void delete(I id) throws PresentationException, DomainException, InfrastructureException;

}
