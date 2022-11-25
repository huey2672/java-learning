package com.huey.learning.java.validation.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
public class BeanValidationSample {

    @Test
    public void testBeanValidation() {

        // 获取校验器
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // 创建一个 Bean
        User user = new User();
        user.setWorking(true);
        user.setAboutMe("Its all about me!");
        user.setAge(50);

        // 校验 Bean
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }


    }

}
