package com.sun.collection.linked;


//单链表实现栈
public class SingleLink {
	
	Node head;//头结点
	int size ;//元素个数
   
	public boolean add(Object data){
		Node node = new Node(null, data);
		if(head == null){
			head = node;
			size++;
			return true;
		}
		node.next = head;
		head = node;
		size++;
		return true;
		
	}
	//先进后出实现栈
	public Object remove(){
		if(head == null){
			return null;
		}
		Object obj = head.data;
		head = head.next;
		return obj;
		
	}
    //删除某个元素
	public boolean removeOne(Object obj){
        if(head == null){
        	return false;
        }
        if(head.data.equals(obj)){
        	size--;
        	return true;
        }
        Node current = head;
        Node provies = head;
        
        while(!current.data.equals(obj)){
        	provies = current;
        	current = current.next;
        	if(current == null){
        		return false;
        	}
        }
        provies.next = current.next;
        size--;
        return true;
	}
	//打印栈中所有元素
	public void display(){
		String str ="";
		Node current = head;
		while(current != null){
			str = str+","+current.data.toString();
			current = current.next;
		}
		System.out.println(str);
	}
}
