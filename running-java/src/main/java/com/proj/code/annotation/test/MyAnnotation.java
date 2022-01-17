package com.proj.code.annotation.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 什么注解
@Retention(RetentionPolicy.RUNTIME)  //反射是在运行时的，所以要加他
@interface MyAnnotation{
    String value();
}
