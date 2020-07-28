package com.sun.pojo;

import com.sun.variableMethod.power;

public class powerDifferPackage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       power p = new power();
       System.out.println(p.name);
       //default本包能访问,别的包下不能使用
//       System.out.println(p.age);
	}

}
