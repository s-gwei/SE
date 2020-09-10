package com.sun.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sun.pojo.User;

public class ReflectDemo05 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// TODO Auto-generated method stub
		//通过对象获取
		User user = new User();
		Class   class1 = user.getClass();
		//获取单个构造方法,通过构造方法创建对象
		Constructor  constructor =  class1.getConstructor();
		Object obj  = constructor.newInstance();
        User user1 = (User) obj;
        user1.setId(9);
        System.out.println(user1);
        //获取无参的方法,通过方法名获取
        Method method  = class1.getMethod("study");
        method.invoke(user1);
        //获取有参的方法，通过方法名，参数类型获取
        Method method2 = class1.getMethod("sum", int.class);
        method2.invoke(obj, 4);
        method2.invoke(user1, 4);
        method2.invoke(class1.newInstance(), 4);
        
        //获取属性值
        Field field = class1.getDeclaredField("name");
        //设置暴力访问
      	field.setAccessible(true);
      	field.set(obj, "张三");
		//打印属性值
		System.out.println(field.get(obj));
	}

}
