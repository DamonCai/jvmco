package com.damon.jvmco.invoke.imp;

import com.damon.jvmco.invoke.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 */
public class JavaInvokeProxy implements InvocationHandler {

    private Object target;

    public JavaInvokeProxy(Object object) {
        this.target = object;
    }


    public Object getProxy() {

        //获得加载被代理类的 类加载器
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        //指明被代理类实现的接口
        Class<?>[] interfaces = this.target.getClass().getInterfaces();

        // 创建被代理类的委托类,之后想要调用被代理类的方法时，都会委托给这个类的invoke(Object proxy, Method method, Object[] args)方法
        JavaInvokeProxy h = new JavaInvokeProxy(this.target);

//        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), this.target.getClass().getInterfaces(), this);
        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), this.target.getClass().getInterfaces(), h);

        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("java动态代理开始");
        result = method.invoke(target, args);
        System.out.println("java动态代理结束");
        return result;
    }


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        JavaInvokeProxy javaInvokeProxy = new JavaInvokeProxy(userService);
        UserService tmp = (UserService) javaInvokeProxy.getProxy();
        tmp.addUser();
    }


}
