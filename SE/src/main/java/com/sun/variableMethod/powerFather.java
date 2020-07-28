package com.sun.variableMethod;

public class powerFather {

	public static void main(String[] args) {
		power p = new power();
		//public 本包都能访问
		System.out.println(p.name);
		//default本包也能访问
		System.out.println(p.age);
	}
}
