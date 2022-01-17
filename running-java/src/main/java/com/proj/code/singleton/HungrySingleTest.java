package com.proj.code.singleton;

/**
 * 一、饿汉式
 * （1）用一个公共的静态的常量来保持这个唯一的实例对象
 * （2）枚举类
 * （3）用一个私有的静态的常量来保持这个唯一的实例对象，再用一个静态方法返回这个唯一的对象。
 */
public class HungrySingleTest {

    public static void main(String[] args) {
        Hungry hungry = Hungry.SINGLETON;
        HungryEnum hungryEnum = HungryEnum.SINGLETON;
        HungryObj hungryObj = HungryObj.getInstance();
    }

    /**
     * 用一个公共的静态的常量来保持这个唯一的实例对象
     */
    static class Hungry {
        public static final Hungry SINGLETON = new Hungry();

        public Hungry() {
        }
    }

    /**
     * 枚举类
     */
    enum HungryEnum {
        SINGLETON;
    }

    /**
     * 用一个私有的静态的常量来保持这个唯一的实例对象，再用一个静态方法返回这个唯一的对象
     */
    static class HungryObj {
        private static final HungryObj SINGLETON = new HungryObj();

        public HungryObj() {
        }

        public static HungryObj getInstance() {
            return SINGLETON;
        }
    }
}






