package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ConstructorConfusion {

	private String someValue;

	public ConstructorConfusion(String someValue) {
		System.out.println("ConstructorConfusion(String) 호출");
		this.someValue = someValue;
	}

	public ConstructorConfusion(int someValue) {
		System.out.println("ConstructorConfusion(int) 호출");
		this.someValue = "숫자 값: " + Integer.toString(someValue);
	}

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
		System.out.println(cc);
		ctx.close();
	}

	public String toString() {
		return someValue;
	}
}
