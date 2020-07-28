package com.sun.variableMethod;
public class Initialize {

	private  int a;//静态函数在对象创建之前就初始化
//	public Initialize(int a){
//		this.a=a;
//	}
	public int getA(){
		return a;
	}

	public static void main(String[] args) {
		int b ;//声明的变量在使用之前必须要初始化，否则会编译错误
		String cString;
//		System.out.println("b="+b);
		//在创建对象时，所有变量都会初始化，
		Initialize initialize = new Initialize();
//		initialize.add();
		System.out.println(initialize.getA());
	}
	
	public void add(){
		int a;//方法中的变量使用之前必须要初始化，否则会编译错误
//		System.out.println(a);
	}
}


