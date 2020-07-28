package com.sun.thread;

public class ThreadTest01 extends Thread {
	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		Thread t1 = new ThreadTest01(a, b);
		Thread t2 = new Thread2(a,b);
		t1.start();
		t2.start();
	}
	private  Object objA;
	private  Object objB;
	
	public ThreadTest01(Object objA, Object objB) {
		super();
		this.objA = objA;
		this.objB = objB;
	}

	public void run() {
		synchronized (objA) {
			try {
				sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + "第" + 1 + "次");
				synchronized (objB) {
					System.out.println("被锁住了");
			}

	}
	}
}
class Thread2 extends Thread{
	private  Object objA;
	private  Object objB;
	
	public Thread2(Object objA, Object objB) {
		super();
		this.objA = objA;
		this.objB = objB;
	}

	public void run() {
	synchronized (objB) {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "第" + 1 + "次");
		synchronized (objA) {
			System.out.println("被锁住了");
		}
	}
	}
}


