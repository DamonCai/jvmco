package com.damon.jvmco.invoke.imp;

import com.damon.jvmco.invoke.UserService;

public class PersonServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("新增1111用户");
    }

    @Override
    public void editUser() {
        System.out.println("编辑1111用户");

    }
}
