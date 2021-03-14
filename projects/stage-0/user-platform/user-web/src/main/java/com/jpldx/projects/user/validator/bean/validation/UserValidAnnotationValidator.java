package com.jpldx.projects.user.validator.bean.validation;

import com.jpldx.projects.user.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author chen.xudong
 * @version 1.0
 * @since 2021/3/11
 */
public class UserValidAnnotationValidator implements ConstraintValidator<UserValid, User> {

    private int idRange;

    public void initialize(UserValid annotation) {
        this.idRange = annotation.idRange();
    }

    public boolean isValid(User value, ConstraintValidatorContext context) {
        return false;
    }
}
