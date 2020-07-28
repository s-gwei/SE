package com.sun.pojo;

import java.io.Serializable;

public class User implements Serializable {

	private  int id;
	
	private  String name;
	
	public User(){
		System.out.println("调用了无参的构造函数");
	}
	public User(int id){
		this.id = id;
	}
 
	public void study(){
		System.out.println("好好学习，天天向上");
	}
	public void sum(int a){
		int b =a+3;
		System.out.println(b);
	}
	
	@Override
	public String toString() {
		System.out.println("调用了toString方法");
		return "User [id=" + id + ", name=" + name + "]";
	}
	public static void eat(int a){
		System.out.println(a);
	}
	public int getId() {
		System.out.println(id);
		return id;
	}

	public void setId(int id) {
		System.out.println(id);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
