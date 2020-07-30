package com.sun.collection.tree;

//二叉查找树常用方法
public class BinarySearchTreeNode {
	
	static BinarySearchTree root;


	public BinarySearchTreeNode(){
		BinarySearchTree root ;
	}
	
	public BinarySearchTreeNode(Integer obj){
		BinarySearchTree root   = new BinarySearchTree(obj);
	}
	//先根遍历
	public void preOrder(BinarySearchTree node){
		if(node != null){
			System.out.println(node.obj);
			preOrder(node.leftNode);
			preOrder(node.rightNode);
		}
	}
	//后根遍历
	public void afterOrder(BinarySearchTree node){
		if(node != null){
			afterOrder(node.leftNode);
			afterOrder(node.rightNode);
			System.out.println(node);
		}
	}
	//中根遍历（得到的数据就是排序后的）
	public  void inOrder(BinarySearchTree node){
		if(node !=null){
			inOrder(node.leftNode);
			System.out.print(node.obj.toString()+" ");
			inOrder(node.rightNode);
		}
	}
	
	 //添加元素
	  public  Boolean add(Integer obj){
		  if(root == null){
			 root = new BinarySearchTree();
			 root.obj = obj;
			 return true;
		  }
		  addNode(root,obj);
		  return true;
		  
	  }
	  //递归算法判断元素添加位置
	  public  BinarySearchTree addNode(BinarySearchTree node ,Integer obj){
		if(node == null){
			node = new BinarySearchTree();
			node.obj = obj;
			return node;
		}
		if(obj< node.obj){
			node.leftNode = addNode(node.leftNode,obj);
		}
		if(obj > node.obj){
			node.rightNode = addNode(node.rightNode,obj);
		}
		return node;  
	  }
	  
	  
}
