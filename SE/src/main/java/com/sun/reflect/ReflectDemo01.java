package com.sun.reflect;

import java.lang.reflect.Method;

import com.sun.pojo.User;

public class ReflectDemo01 {

	public static  void main(String[] args)  {
		// 获取class对象的三种方式
        //1.通过类名获取
		Class class1 = User.class;
		Method[] methods  = class1.getDeclaredMethods();
		//2.通过对象获取
		User user = new User();
		Class   class2 = user.getClass();
		//3.通过类全名获取
		try {
			Class class3 = Class.forName("com.sun.pojo.User");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
