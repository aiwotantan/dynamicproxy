package com.tantan.jvm.dynamicproxy.jdk;

//2、定义真实角色
public class RealSubject implements Subject {

	@Override
	public void Request() {

		System.out.println("RealSubject");
	}

}
