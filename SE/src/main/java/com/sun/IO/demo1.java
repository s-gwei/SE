package com.sun.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demo1 {

	public static void main(String[] args) throws IOException {

		// 类型
//		chType();
		//运算符
//		number();
//		dou();
		doub();
	}

	// io流
	public static void input() throws Exception {
		File file = new File("D:\\1.txt"); // 新建一个文件的抽象路径
		FileInputStream io = new FileInputStream(file);
		int count;
		byte[] bytes = new byte[1024];
		while ((count = io.read(bytes)) != -1) {
			String str = new String(bytes, 0);
		}
	}

	public static char type() {
		byte by = 127;
		short sh = 32767;
		int in = 2147483647;
		char ch = 'a';
		return ch;

	}
	public static void chType(){
		char ch1 = '\\';
		char ch2 = '\u2605';
		System.out.println(ch1);
		System.out.println(ch2);
	}
    //运算符
	public static void number(){
		int a = 1 ;
//		int b=++a*(a+1)*2;//值为3,++a是在使用a之前+1
		int c=(a++)*(a+1)*(a+1);//值为6,a++是在使用a之后+1
		
		System.out.println(c);
	}
	//double有效數字(最好是15位)
	public static void doub(){
		double a = 999999999999999d;
		System.out.println(a);
	}
	public static void dou(){
//		double a = 98765432109876543210d;	
//		System.out.println(a);
		int a = 2>>>3;
//		System.out.println(a);
		byte b;
		int c = 1280;
		b=(byte) c;
		System.out.println(b);
		if(a==100){
			
		}
	}
	
	
}
