package com.tantan.jvm.dynamicproxy.cglib;

public class mainTest {
    public static void main(String[] args) {
        //创建目标对象/被代理对象
        User user = new User();
        //创建代理工厂对象
        ProxyFactory proxyFactory = new ProxyFactory(user);
        //创建代理对象（强制类型转换，方便调用方法）
        User proxyInstance = (User) proxyFactory.getProxyInstance();
        proxyInstance.setName("root");
        System.out.println(proxyInstance.getName());
    }
}


