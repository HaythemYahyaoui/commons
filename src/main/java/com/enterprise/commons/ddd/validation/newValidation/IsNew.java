package com.enterprise.commons.ddd.validation.newValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsNewValidation.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNew {

    String message() default "";

    boolean value() default true;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}