package com.sun.collection.linked;

public class Test {
	public static void main(String[] args) {
		SingleLink singleLink = new SingleLink();
		singleLink.add(1);
		singleLink.add(2);
		singleLink.add(3);
//		System.out.println(singleLink.head.data);
//		System.out.println(singleLink.removeOne(1));
		singleLink.display();
	}

}
