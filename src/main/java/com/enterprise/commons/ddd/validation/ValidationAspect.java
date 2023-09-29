package com.enterprise.commons.ddd.validation;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.ConstructorSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

@Log4j2
@Aspect
public class ValidationAspect {

    private Validator validator;

    public ValidationAspect() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        try( LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean()){
            factory.setValidationMessageSource(messageSource);
            factory.afterPropertiesSet();
            validator = factory.getValidator();
        }
    }

    @Pointcut("within(@com.enterprise.commons.ddd.validation.Validation *)")
    public void annotatedWithValidation() {

    }

    @Pointcut("execution(public *.new(*,..))")
    public void allPublicConstructorWithArguments() {

    }

    @Pointcut("execution(public * *(*,..))")
    public void allPublicMethodWithArguments() {

    }

    @Pointcut("(annotatedWithValidation() && (allPublicMethodWithArguments() || allPublicConstructorWithArguments())) || " +
            "(@annotation(com.enterprise.commons.ddd.validation.Validation) && (allPublicMethodWithArguments() || allPublicConstructorWithArguments()))")
    public void validation() {

    }

    @Around("validation()")
    public Object  around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Aspect Validation : "+joinPoint.getSignature().toShortString());
        Set<ConstraintViolation<Object>> allConstraintViolations = new HashSet();
        if(joinPoint.getSignature() instanceof MethodSignature){
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Set<ConstraintViolation<Object>> constraintViolations = validator.forExecutables().validateParameters(joinPoint.getTarget(), signature.getMethod(), joinPoint.getArgs());
            allConstraintViolations.addAll(constraintViolations);
        }else if (joinPoint.getSignature() instanceof ConstructorSignature){
            ConstructorSignature signature = (ConstructorSignature) joinPoint.getSignature();
            Set<ConstraintViolation<Object>> constraintViolations = validator.forExecutables().validateConstructorParameters(signature.getConstructor(), joinPoint.getArgs());
            allConstraintViolations.addAll(constraintViolations);
        }
        if(allConstraintViolations.size() > 0) {
            throw new ConstraintViolationException(allConstraintViolations);
        }else {
            return joinPoint.proceed();
        }
    }

}