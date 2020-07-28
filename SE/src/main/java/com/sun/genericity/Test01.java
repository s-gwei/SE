package com.sun.genericity;

import java.util.ArrayList;
import java.util.List;

//
public class Test01 {
	
	public static void main(String[] args) {
		List  list =new ArrayList();
		list.add(1);
		list.add("a");
		System.out.println(list.toString());
	}
	//泛型方法
    public <T> void add(T t){
    	System.out.println(t.toString());
    }
}
