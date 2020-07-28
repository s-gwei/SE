package com.sun.reflect;

import java.io.FileDescriptor;
import java.lang.reflect.Field;

import com.sun.pojo.User;

public class ReflectDemo04 {

	//获取类的成员变量,通过反射获取private修饰的变量
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        Class clazz = User.class;
        
		Object obj  = clazz.newInstance();
		//获取单个属性
		Field field = clazz.getDeclaredField("name");
		//设置暴力访问
		field.setAccessible(true);
		//设置属性值，clazz.newInstance()执行一次就创建一个对象，
		//所以不能用clazz.newInstance()代替obj
		field.set(obj, "张三");
		//打印属性值
		System.out.println(field.get(obj));
	}

}
