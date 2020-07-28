package com.sun.variableMethod;

public class Son extends Father{

/*	继承的子类：

    父类静态变量
    父类静态代码块
    子类静态变量
    子类静态代码块
    父类普通变量
    父类普通代码块
    父类构造函数
    子类普通变量
    子类普通代码块
    子类构造函数*/

	public static String sonStaticField = getSonStaticField();
	
	public static String getSonStaticField(){
		System.out.println("这是子类的静态属性");
		return "这是子类的静态属性";
	}
	
	public String sonField = getField();
	
	public String getField(){
		System.out.println("这是子类的普通属性");
		return "这是子类的普通属性";
	}
	static{
		System.out.println("这是子类的静态代码块");
	}
	{
		System.out.println("这是子类的普通代码块");
	}
	public Son(){
		System.out.println("这是子类的构造方法");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new Son();
	}

}
class Father{
	
	public static String fatherStaticField = getFatherStaticField();
	
	public static String getFatherStaticField(){
		System.out.println("这是father的静态属性");
		return "这是father的静态属性";
	}
	
	public  String fatherField = getFatherField();
	
	public  String getFatherField(){
		System.out.println("这是father的普通属性");
		return "这是father的普通属性";
	}
	static{
		System.out.println("这是father的静态代码块");
	}
	{
		System.out.println("这是father的普通代码块");
	}
	public Father(){
		System.out.println("这是父类的构造方法");
	}
}