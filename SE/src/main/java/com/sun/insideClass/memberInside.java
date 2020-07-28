package com.sun.insideClass;

public class memberInside {

	private int a = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
	}
     private class A{
	   A() {
	}
	 public A getInst(){
		 System.out.println(a);
		 return new A();
	 }
   }
}
