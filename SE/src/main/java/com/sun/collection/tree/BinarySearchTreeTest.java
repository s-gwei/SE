package com.sun.collection.tree;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		BinarySearchTreeNode root = new BinarySearchTreeNode();
		root.add(10);
		root.add(9);
		root.add(98);
		root.add(4);
		root.add(100);
		root.inOrder(root.root);
		
	}

}
