package com.sun.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sun.pojo.User;

public class ReflectDemo02 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	   //通过对象获取class对象
       User user  =  new  User();
       Class class1 = user.getClass();
       //获取所有的构造方法
       Constructor[]  constructors = class1.getConstructors();
       for(Constructor constructor : constructors){
//    	   System.out.println(constructor);
       }
       //获取单个构造
       Constructor  constructor = class1.getConstructor();
       System.out.println(constructor);
       //通过构造创建对象
       Object obj   =  constructor.newInstance();
       User  users  =  (User)obj;
       user.setId(9);
       System.out.println(user.getId());
       //简化
       Object obj1  = class1.newInstance();
       
	}

}
