package com.enterprise.commons.ddd.repository;

import com.enterprise.commons.ddd.domain.entity.Entity;
import com.enterprise.commons.exception.InfrastructureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;
import java.util.Optional;

@Slf4j
public abstract class AbstractMongoDBRepository<T extends Entity<I>, I> implements EntityRepository<T, I> {

    protected MongoRepository<T, I> mongoRepository;

    public AbstractMongoDBRepository(MongoRepository<T, I> mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public T getById(I id) throws InfrastructureException {
        Optional<T> byId = mongoRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new InfrastructureException(InfrastructureError.RESOURCE_NOT_FOUND);
        }
    }

    @Override
    public T save(T entity) throws InfrastructureException {
        return mongoRepository.save(entity);
    }

    @Override
    public void delete(I id) throws InfrastructureException {
        T entity = this.getById(id);
        mongoRepository.delete(entity);
    }

    @Override
    public void update(T entity) throws InfrastructureException {
        mongoRepository.save(entity);
    }

    @Override
    public Collection<T> findAll(Pageable pageable) throws InfrastructureException {
        return mongoRepository.findAll(pageable).getContent();
    }

}
