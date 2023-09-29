package com.enterprise.commons.ddd.controller;

import com.enterprise.commons.ddd.business.EntityBusiness;
import com.enterprise.commons.ddd.domain.entity.Entity;
import com.enterprise.commons.ddd.service.EntityService;
import com.enterprise.commons.exception.DomainException;
import com.enterprise.commons.exception.InfrastructureException;
import com.enterprise.commons.exception.PresentationException;
import org.springframework.data.domain.Pageable;

import java.util.Collection;


public abstract class AbstractEntityController<T extends Entity, I> implements EntityController<T, I> {

    protected EntityService<T, I> entityService;

    public AbstractEntityController(EntityService<T, I> entityService) {
        this.entityService = entityService;
    }

    @Override
    public T getById(I id) throws PresentationException, DomainException, InfrastructureException {
        return entityService.getById(id);
    }

    @Override
    public Collection<T> findAll(Pageable pageable) throws PresentationException, DomainException, InfrastructureException {
        return entityService.findAll(pageable);
    }

    @Override
    public void delete(I id) throws PresentationException, DomainException, InfrastructureException {
        entityService.delete(id);
    }

}
