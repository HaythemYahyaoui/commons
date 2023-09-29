package com.enterprise.commons.validator;

import org.springframework.context.support.ResourceBundleMessageSource;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public final class BusinessValidator {

    private static Validator VALIDATOR;

    private BusinessValidator() {

    }

    public static Validator getInstance() {
        if(VALIDATOR == null){
            VALIDATOR = getFactory().getValidator();
        }
        return VALIDATOR;
    }

    private static ValidatorFactory getFactory() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        try( LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean()){
            factory.setValidationMessageSource(messageSource);
            factory.afterPropertiesSet();
            return factory;
        }
    }

}