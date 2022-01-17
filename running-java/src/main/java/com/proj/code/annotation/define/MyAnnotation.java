package com.proj.code.annotation.define;

import java.lang.annotation.*;

/**
 * (1)声明注解
 */
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface MyAnnotation {

}
