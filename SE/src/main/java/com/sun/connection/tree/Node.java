package com.sun.connection.tree;
/*
 * 二叉树的三种遍历方式
 */

public class Node {

	int key;
	double data;
	Node leftChild;
	Node rightChild;
	
	public Node(double data){
		this.data=data;
	}
	public static void main(String[] args) {
		Node p = new Node(5);
		p.leftChild = new Node(3);
		p.rightChild = new Node(7);
		p.leftChild.leftChild = new Node(2);
		p.leftChild.rightChild = new Node(4);
		p.rightChild.leftChild = new Node(6);
		p.rightChild.rightChild = new Node(8);
//		preOrder(p);//遍历顺序是根节点，左节点，右节点
		inOrder(p);//遍历顺序是左节点，根节点，右节点，中根遍历就是排序好的数据
//		lateOrder(p);//遍历顺序是左节点，右节点，根节点
	}
	/**
     * 先根遍历
     * @param p
     */
	public static void preOrder(Node p){
		if(p!=null){
			System.out.print(p.data+" ");
			preOrder(p.leftChild);
			preOrder(p.rightChild);
		}
	}
	 /**
     * 中根遍历
     * @param p
     */
	public static void inOrder(Node p){
		if(p!=null){
			inOrder(p.leftChild);
			System.out.print(p.data+" ");
			inOrder(p.rightChild);
		}
	}
	/**
	 * 后根遍历
	 */
	public static void lateOrder(Node p){
		if(p!=null){
			lateOrder(p.leftChild);
			lateOrder(p.rightChild);
			System.out.print(p.data+" ");
		}
	}
	
	/**
	 * 层级遍历
	 */
	public static void storey(Node p){
		
	}
}
