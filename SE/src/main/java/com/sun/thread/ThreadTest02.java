package com.sun.thread;

public class ThreadTest02 extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建线程对象
		ThreadTest02 thread02 = new ThreadTest02();
		//启动线程
		thread02.start();
		//执行main方法
		for(int i = 0;i < 10;i++){
			System.out.println("main:"+i);
		}
	}
        //重写run方法
	public void run() {
		//执行run方法
		for(int i=0;i<10;i++){
			System.out.println("run:"+i);
		}
	}
}
