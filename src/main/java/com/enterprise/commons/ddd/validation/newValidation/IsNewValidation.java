package com.enterprise.commons.ddd.validation.newValidation;

import com.enterprise.commons.ddd.domain.entity.Entity;
import lombok.extern.log4j.Log4j2;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Log4j2
public class IsNewValidation implements ConstraintValidator<IsNew, Entity> {

    private IsNew isNew;

    @Override
    public void initialize(IsNew isNew) {
        this.isNew = isNew;
    }

    @Override
    public boolean isValid(Entity entity,
                           ConstraintValidatorContext context) {

        if(entity == null){
            return true;
        }

        /*if(entity.isNew() && !isNew.value()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate( "Entity must be aleardy persisted").addConstraintViolation();
        }

        if(!entity.isNew() && isNew.value()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate( "Entity must be new object not persisted").addConstraintViolation();
        }

        return !((!entity.isNew() && isNew.value()) || (entity.isNew() && !isNew.value()));*/
        return true;
    }

}