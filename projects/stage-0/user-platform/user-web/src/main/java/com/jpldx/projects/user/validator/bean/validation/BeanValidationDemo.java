package com.jpldx.projects.user.validator.bean.validation;

import com.jpldx.projects.user.domain.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author chen.xudong
 * @version 1.0
 * @since 2021/3/13
 */
public class BeanValidationDemo {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        User user = new User();
        user.setPassword("***");

        Set<ConstraintViolation<User>> validate = validator.validate(user);
        validate.forEach(v->{
            System.out.println(v.getMessage());
        });
    }
}
