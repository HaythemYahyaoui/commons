package com.enterprise.commons.ddd.domain.entity;


import java.io.Serializable;


public interface Entity<I> extends Serializable {
    I getId();
}
