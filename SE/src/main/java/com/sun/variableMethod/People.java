package com.sun.variableMethod;

public class People  {
/*
	普通类:加载顺序

    静态变量
    静态代码块
    普通变量
    普通代码块
    构造函数*/

	public static  String staticField = getStaticField();
	
	public static String getStaticField(){
		System.out.println("静态属性初始化");
		return "静态属性";
	}
	
	public String field = getField();
	public static String getField(){
		System.out.println("普通属性初始化");
		return "普通属性";
	}
	static{
		 System.out.println(staticField);
	     System.out.println("静态方法块初始化");
	     System.out.println("Static Patch Initial");
	}
	{
		 System.out.println(field);
	     System.out.println("普通方法块初始化");
	     System.out.println(" Patch Initial");
	}
	
	public People(){
		System.out.println("这是构造方法");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       People son = new People();
       
	}

}

