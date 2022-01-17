package com.proj.code.annotation.define;

import java.lang.annotation.Annotation;

/**
 * 自定义注解：
 * （1）声明
 * （2）使用
 * （3）读取
 * <p>
 * 一、声明
 * 格式：
 * 【权限修饰符】 @interface 注解名{
 * }
 * <p>
 * 二、使用
 * =>@注解名
 * <p>
 * 三、读取
 * 特别说明，如果需要用“反射”读取某个注解，那么这个注解声明的时候，一定要增加这个元注解@Retention(RetentionPolicy.RUNTIME)
 *
 * 四、元注解
 * 元注解：注解注解的注解，给注解加的注解，在注解声明时，在上面加的注解
 * 元数据：
 * 元...：
 * <p>
 * 1、@Target(xx)
 * 用来标记这个注解可以用在xx位置
 * 这个位置有ElementType枚举的常量对象来指定
 * 2、@Retention(xx)
 * 作用：标记这个注解可以滞留到xx阶段
 * 这个生命周期有RetentionPolicy枚举的常量对象来指定。
 * SOURCE(源代码)，CLASS(子节点阶段)，RUNTIME(运行时)
 * 3、@Documented
 * 作用:标记这个注解是否可以被javadoc.exe读取到API中。
 * 4、@Inherited
 * 作用：标记这个注解是否可以被子类继承
 *
 */
public class DefineAnnotationTest {
    public static void main(String[] args) {
        //反射
        Class clazz = MyClass.class;
        Annotation annotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation);

        //测试 @Inherited
        Class clazz2 = SubMyClass.class;
        Annotation annotation2 = clazz2.getAnnotation(MyAnnotation.class);
        System.out.println(annotation2);
    }
}

