package com.sun.thread;

public class RunableTest10 implements Runnable {

	/*
	 * 给多线程执行的代码加锁，这样就保证了该代码只能单线程执行，实现了线程安全
	 */
	private int tickets = 50;
	private static Object obj = new Object();//锁的对象，可以是任意的对象
	public void run() {
		// TODO Auto-generated method stub
			while(tickets > 0){
			    synchronized (this) {
				System.out.println(Thread.currentThread().getName()+"卖出了第"+
			      (50-tickets+1)+"张票");
				tickets--;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunableTest10 test10 = new RunableTest10();
		Thread t1 = new Thread(test10,"t1");
		Thread t2 = new Thread(test10,"t2");
		t1.start();
		t2.start();
	}

	
}
