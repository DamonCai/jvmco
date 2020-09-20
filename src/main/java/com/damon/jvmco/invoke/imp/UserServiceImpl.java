package com.damon.jvmco.invoke.imp;

import com.damon.jvmco.invoke.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("新增用户");
    }

    @Override
    public void editUser() {
        System.out.println("编辑用户");

    }
}
