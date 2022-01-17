package com.proj.code.api_reflect.generic_superclass;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GetGenericSuperclassTest {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("com.proj.code.api_reflect.generic_superclass.Son");

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument.getTypeName());
        }

    }
}


