package com.sun.insideClass;

public class OuterClass {

	private int a = 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass out = new OuterClass();
//		InnerClass in = out.getInnerClass();
		InnerClass in1 = out.new InnerClass();	
	}
	private InnerClass getInnerClass(){
		System.out.println(a);
		return new InnerClass();
	}
	private class InnerClass{
		InnerClass(){
			
		}
		
		
	}
}
