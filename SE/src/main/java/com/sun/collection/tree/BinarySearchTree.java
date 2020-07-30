package com.sun.collection.tree;

//二叉查找树Node
public class BinarySearchTree {
	
	
	
	  
	  public BinarySearchTree parentNode;//待定
	  
	  public BinarySearchTree leftNode;
	  
	  public BinarySearchTree rightNode;
	  
	  public Integer obj;
	  
	  public BinarySearchTree(){
		  this.parentNode = null;
		  this.leftNode = null;
		  this.rightNode = null;
	  }
	  public BinarySearchTree(Integer obj){
		 
		  this.obj = obj;
	  }
	
	

}
