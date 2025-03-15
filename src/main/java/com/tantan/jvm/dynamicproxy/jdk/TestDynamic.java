package com.tantan.jvm.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 
 * Description: 测试动态代理
 */
public class TestDynamic {

	public static void main(String[] args) {
		
		//4、通过Proxy.newProxyInstance构建代理对象
		
		//新建一个对象：该对象继承一个通用接口，实现里面方法
		RealSubject realSub = new RealSubject();
		
		//把该新建对象传入动态代理对象内中，：该动态代理类实现invokehandle接口，实现invoke方法，
		InvocationHandler handler = new DynamicSubject(realSub);
		Class<?> classType = handler.getClass();
		
		//代理对象新建一个实例，传入改新建对象。动态代理handler,生成以该新建对象为内核的多态接口对象
		Subject sub = (Subject)Proxy.newProxyInstance(classType.getClassLoader(),
		realSub.getClass().getInterfaces(), handler);
		
		//新建的代理对象，它实现指定的接口
		System.out.println(sub.getClass()); 
		
		//5、通过调用代理对象的方法去调用真实角色的方法。
		
		
		//该超级接口调用通用方法，实则是调用内核对象的方法。：动态代理类的invoke的实现方法也会被调用
		sub.Request();
		
		
	}
}
