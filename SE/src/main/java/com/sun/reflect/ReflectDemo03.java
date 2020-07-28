package com.sun.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sun.pojo.User;

public class ReflectDemo03 {
	//获取一个类的成员方法
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// TODO Auto-generated method stub
        //获取类的所有方法
		User  user  =  new  User();
		Class clazz = user.getClass();
//		Object object = clazz.newInstance();
		//获取无参的方法
//		Method method  = clazz.getMethod("study");
//		//clazz.newInstance()通过class对象创建java对象。
//		method.invoke(object);
		
		//获取有参的构造(在方法名后加上参数的)
		//int.class原始类型int的Class对象引用
//		Method method1  = clazz.getMethod("sum",int.class);
//		method1.invoke(user, 1);
		
		//获取set，get方法,目前设置进去的值，没有通过get方法获取到
		Method  method2 = clazz.getMethod("setId", int.class);
		method2.invoke(clazz.newInstance(), 4);
		
	}

}
