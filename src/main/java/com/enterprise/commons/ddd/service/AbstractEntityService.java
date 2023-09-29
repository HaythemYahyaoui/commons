package com.enterprise.commons.ddd.service;

import com.enterprise.commons.ddd.business.EntityBusiness;
import com.enterprise.commons.ddd.domain.entity.Entity;
import com.enterprise.commons.exception.DomainException;
import com.enterprise.commons.exception.InfrastructureException;
import org.springframework.data.domain.Pageable;

import java.util.Collection;


public abstract class AbstractEntityService<T extends Entity, I> implements EntityService<T, I> {

    protected EntityBusiness<T, I> entityBusiness;

    public AbstractEntityService(EntityBusiness<T, I> entityBusiness) {
        this.entityBusiness = entityBusiness;
    }

    @Override
    public T getById(I id) throws DomainException, InfrastructureException {
        return entityBusiness.getById(id);
    }

    @Override
    public Collection<T> findAll(Pageable pageable) throws DomainException, InfrastructureException {
        return entityBusiness.findAll(pageable);
    }

    @Override
    public void delete(I id) throws DomainException, InfrastructureException {
        entityBusiness.delete(id);
    }

}
