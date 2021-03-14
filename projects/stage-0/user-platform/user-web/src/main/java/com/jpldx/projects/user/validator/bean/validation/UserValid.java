package com.jpldx.projects.user.validator.bean.validation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chen.xudong
 * @version 1.0
 * @since 2021/3/11
 */
@Target(ElementType.TYPE) // 类注解
@Retention(RetentionPolicy.RUNTIME) // 保留策略：运行时
@Constraint(validatedBy = {UserValidAnnotationValidator.class}) // ConstraintValidator 实现类数组
public @interface UserValid {

    int idRange() default 0;
}
