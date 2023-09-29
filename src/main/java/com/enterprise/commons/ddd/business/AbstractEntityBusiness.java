package com.enterprise.commons.ddd.business;

import com.enterprise.commons.ddd.domain.entity.Entity;
import com.enterprise.commons.ddd.repository.EntityRepository;
import com.enterprise.commons.exception.DomainException;
import com.enterprise.commons.exception.InfrastructureException;
import org.springframework.data.domain.Pageable;

import java.util.Collection;


public abstract class AbstractEntityBusiness<T extends Entity<I>, I> implements EntityBusiness<T, I> {

    protected EntityRepository<T, I> entityRepository;

    public AbstractEntityBusiness(EntityRepository<T, I> entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public T getById(I id) throws DomainException, InfrastructureException {
        return entityRepository.getById(id);
    }

    @Override
    public Collection<T> findAll(Pageable pageable) throws DomainException, InfrastructureException {
        return entityRepository.findAll(pageable);
    }

    @Override
    public void delete(I id) throws DomainException, InfrastructureException {
        entityRepository.delete(id);
    }

}
