package com.sun.connection.tree;

import java.util.ArrayList;
import java.util.Collections;

public class NodeTest {
	Node root;
	static ArrayList<Double> data;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Node root = new Node(5);
          root = addNode(root,4);
          root = addNode(root,6);
          root = addNode(root,3);
          root = addNode(root,7);
          root = addNode(root,5);
          root.preOrder(root);
          boolean flag = contains(root,5);
          System.out.println(flag);
      
	}
    //添加节点，递归的添加方式
	public static Node addNode(Node root,int key){
		if(root == null){
			return new Node(key);
		}
		if(root.data>key){
			root.leftChild = addNode(root.leftChild,key);
		}else{
			root.rightChild = addNode(root.rightChild,key);
		}
		return root;
		
	}
	//添加节点，非递归的方式添加
	public static Node addNode_1(Node root,int key){
		if(root == null){
			return new Node(key);
		}
		Node temp = root;
		while(temp != null){
			if(key >= temp.data){
				Node temp1 = temp;
				temp = temp.rightChild;
				if(temp == null){
					temp = new Node(key);
					temp1.rightChild = temp;
					return root;
				}
			}else{
				Node temp1 = temp;
				temp = temp.leftChild;
				if(temp == null){
					temp = new Node(key);
					temp1.leftChild = temp;
					return root;
				}
			}
		}
		return root;
	}
	//查找二叉树中是否有某个元素
	public static boolean contains(Node current,int key){
		if(current == null){
			return false;
		}
		else if(current.data == key){
			return true;
		}
      return key<current.data ? contains(current.leftChild,key):
    	  contains(current.rightChild,key);
	}
	//删除一个节点
	private Node deleteNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.data) {
            if (current.leftChild == null && current.rightChild == null) {
                return null;
            }
            if (current.leftChild == null) {
                return current.rightChild;
            }
            if (current.rightChild == null) {
                return current.leftChild;
            }
            int smallestValue = findSmallestValue(current.rightChild);
            current.data = smallestValue;
            current.rightChild = deleteNode(current.rightChild, smallestValue);
            return current;
        }
        if (value < current.data) {
            current.leftChild = deleteNode(current.leftChild, value);
            return current;
        }
        current.rightChild = deleteNode(current.rightChild, value);
        return current;
    }
    private int findSmallestValue(Node root) {
        return (int) (root.leftChild == null ? root.data : findSmallestValue(root.rightChild));
    }
    
    //实现二叉树节点分布
    public static Node order(Node current){
    	if(current == null){
    		return null;
    	}
    	inOrder(current);
    	Collections.sort(data);
    	int i = data.size();
    	double[] dou = new double[i];
    	int j=0;
    	for(Double d :data){
    		dou[j]=d;
    		j++;
    	}
    	if(i%2 == 0){
    		double a = dou[i%2];
    		Node root = new Node(a);
    	}else{
    		double a = dou[(i+1)%2];
    		Node root = new Node(a);
    	}
		return current;
    	
    	
    }
    //将所有节点重新排列
    //遍历所有节点
    public static ArrayList<Double> inOrder(Node current){
    	if(current !=null){
    		inOrder(current.leftChild);
    		data.add(current.data);
			inOrder(current.rightChild);
    	}
		return null;
    }
}

