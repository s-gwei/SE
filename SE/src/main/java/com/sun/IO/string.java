package com.sun.IO;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		trim();
//		subString();
//		indexOf();
//		replace();
//		spilt();
		User user = new User();
		user.setId(1);
		change(user);
		System.out.println(user);
	}
	//去掉字符串前后空格
    private static void trim(){
    	String str = " hello world ";
    	System.out.println(str);
    	System.out.println(str.trim());
    }
    //获取子字符串
    private static void subString(){
    	String str = " hello world ";
    	System.out.println(str.substring(6));
    }
    //字符串查找
    private static void indexOf(){
    	String str = " hello world ";
    	System.out.println(str.indexOf("l"));
    }
    //字符串替换
    private static void replace(){
    	String str = " hello world ";
    	System.out.println(str.replace("world", "China"));
    }
    //字符串分割
    private static void spilt(){
    	String str = "hello.hello|world ";
    	String[] strArray = str.split("\\.");//特殊字符需要转义比如.和|都需要\\转义
    	String s = str.replace(".", "");
    	System.out.println(str.replace(".", "").length());
    	System.out.println(s);
    	/*for(String s :strArray){
    		System.out.println(s);
    	}*/
    	
    }
    
    //在方法中修改对象值
    public static void change(User user){
    	user.setName("张三");
    }
}
