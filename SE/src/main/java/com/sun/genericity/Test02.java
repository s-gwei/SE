package com.sun.genericity;
//泛型类
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Test02<T> {
	//key这个成员变量的类型为T,T的类型由外部指定  
	private T t;
	
	public Test02(){
		
	}
	public Test02(T t){ //泛型构造方法形参key的类型也为T，T的类型由外部指定
		
	}
	private void add(T t){
		
	}
	public T get(T t){
		return t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Test02<String> test02 = new Test02<String>();
	}

}
