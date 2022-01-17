package com.proj.code.api_reflect.proxy.dynamic;

class UserDaoImpl implements UserDao {
    @Override
    public void insert() {
        System.out.println("添加数据");
    }

    @Override
    public void delete() {
        System.out.println("删除数据");
    }
}
