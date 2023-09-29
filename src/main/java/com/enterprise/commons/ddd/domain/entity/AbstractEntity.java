package com.enterprise.commons.ddd.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class AbstractEntity<I> implements Entity<I> {

    @Id
    @EqualsAndHashCode.Include
    protected I id;

    public AbstractEntity(I id) {
        this.id = id;
    }

    @Override
    public I getId() {
        return id;
    }

}
