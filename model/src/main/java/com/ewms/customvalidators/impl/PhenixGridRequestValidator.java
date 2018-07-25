package com.ewms.customvalidators.impl;

import com.ewms.PhenixRequest;
import com.ewms.customvalidators.PhenixGridRequestValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhenixGridRequestValidator implements ConstraintValidator<PhenixGridRequestValidation, PhenixRequest> {

    @Override
    public void initialize(PhenixGridRequestValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(PhenixRequest object, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        if (!(object instanceof PhenixRequest)) {
            throw new IllegalArgumentException("@PhenixGridRequestValidation only applies to grid request");
        }

        if (object == null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Class is null")
                    .addConstraintViolation();
        } else {

            if (object.getGridName() == null) {
                context
                        .buildConstraintViolationWithTemplate("gridName  is null WTF")
                        .addPropertyNode("gridName")
                        .addConstraintViolation();
            }
            if (object.getFilterBy() == null) {
                context
                        .buildConstraintViolationWithTemplate("filterBy  is no no no")
                        .addPropertyNode("filterBy")
                        .addConstraintViolation();
            }
            if (object.getGridIdentifier() == null) {
                context
                        .buildConstraintViolationWithTemplate("another null oh shit")
                        .addPropertyNode("gridIdentifier")
                        .addConstraintViolation();
            }
            return false;
        }
        return true;
    }
}