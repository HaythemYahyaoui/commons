package com.enterprise.commons.ddd.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.METHOD})
public @interface Validation {
}
