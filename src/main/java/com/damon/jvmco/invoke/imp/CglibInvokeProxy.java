package com.damon.jvmco.invoke.imp;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 * <p>
 * =================================原理======================
 * <p>
 * jdk静态代理实现比较简单，一般是直接代理对象直接包装了被代理对象。
 * <p>
 * jdk动态代理是接口代理，被代理类A需要实现业务接口，业务代理类B需要实现InvocationHandler接口。
 * <p>
 * jdk动态代理会根据被代理对象生成一个继承了Proxy类，并实现了该业务接口的jdk代理类，该类的字节码会被传进去的ClassLoader加载，创建了jdk代理对象实例，
 * <p>
 * jdk代理对象实例在创建时，业务代理对象实例会被赋值给Proxy类，jdk代理对象实例也就有了业务代理对象实例，同时jdk代理对象实例通过反射根据被代理类的业务方法创建了相应的Method对象m（可能有多个）。当jdk代理对象实例调用业务方法，如proxy.addUser();这个会先把对应的m对象作为参数传给invoke()方法（就是invoke方法的第二个参数），调用了jdk代理对象实例的invoke()回调方法，在invoke方法里面再通过反射来调用被代理对象的因为方法，即result = method.invoke(target, args);。
 * <p>
 * cglib动态代理是继承代理，通过ASM字节码框架修改字节码生成新的子类，重写并增强方法的功能。
 * <p>
 * ==============================================
 * <p>
 * jdk静态代理类只能为一个被代理类服务，如果需要代理的类比较多，那么会产生过多的代理类。jdk静态代理在编译时产生class文件，运行时无需产生，可直接使用，效率好。
 * <p>
 * jdk动态代理必须实现接口，通过反射来动态代理方法，消耗系统性能。但是无需产生过多的代理类，避免了重复代码的产生，系统更加灵活。
 * <p>
 * cglib动态代理无需实现接口，通过生成子类字节码来实现，比反射快一点，没有性能问题。但是由于cglib会继承被代理类，需要重写被代理方法，所以被代理类不能是final类，被代理方法不能是final。
 */
public class CglibInvokeProxy implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理实例
     *
     * @param target
     * @return
     */

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //设置回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }


    /**
     * 实现MethodInterceptor接口要重写的方法。
     * 回调方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("Cglib动态代理开始");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("Cglib动态代理结束");
        return result;
    }


    public static void main(String[] args) {
        CglibInvokeProxy cglibInvokeProxy = new CglibInvokeProxy();
        StaffServiceImpl userService = (StaffServiceImpl) cglibInvokeProxy.getInstance(new StaffServiceImpl());
        userService.addUser();
    }

}
