package com.tantan.jvm.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理工厂
 */
public class ProxyFactory implements MethodInterceptor {
    //目标对象/被代理对象属性
    private Object target;

    //有参构造传参
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //实例化代理对象
    public Object getProxyInstance(){
        //1.创建工具类
        Enhancer enhancer = new Enhancer();
        //2.设置代理对象的父类为目标对象
        enhancer.setSuperclass(target.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类对象，即代理对象
        return enhancer.create();
    }

    //重写intercept方法，调用目标对象的方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理模式开始");
        //调用目标对象的方法
        Object returnVal = method.invoke(target, objects);
        System.out.println("Cglib代理模式完毕");
        return returnVal;
    }
}