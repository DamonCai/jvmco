package com.damon.jvmco.invoke.imp;

import com.damon.jvmco.invoke.UserService;

/**
 * 静态代理
 */
public class UserServiceProxy implements UserService {

    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addUser() {
        System.out.println("新增用户代理前");
        userService.addUser();
        System.out.println("新增用户代理后");

    }

    @Override
    public void editUser() {
        System.out.println("编辑用户代理前");
        userService.editUser();
        System.out.println("编辑用户代理后");

    }

    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userServiceImpl);
        userServiceProxy.addUser();
        System.out.println("======================");
        userServiceProxy.editUser();
        System.out.println("============Person==========");
        UserService personServiceImpl = new PersonServiceImpl();
        UserServiceProxy personServiceProxy = new UserServiceProxy(personServiceImpl);
        personServiceProxy.addUser();
        personServiceProxy.editUser();

    }
}
