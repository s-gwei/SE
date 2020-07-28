package com.sun.thread;

public class RunableTest11 implements Runnable {

	/*
	 * 给方法加锁，锁对象是谁呢，是this，为什么是this呢
	 * 当用锁对象用obj，方法加锁，发现数据还是错乱，当同步代码块用this，数据正常，说用
	 * 同步方法的锁是this
	 * static是类对象，class对象，如果在静态方法上加锁，那么锁对象就是RunableTest11.class,
	 * 所以相应的同步代码块也要加RunableTest11.class
	 */
	private static  int tickets=50;
	private Object object = new Object();
	private static boolean flag  = true;
	public void run() {
		// TODO Auto-generated method stub
		if(flag){
			while(tickets>0){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   synchronized (RunableTest11.class) {
				System.out.println(Thread.currentThread().getName()+"卖出第"
						+(50-tickets+1)+"得票");
				tickets--;
			   }
		    }
		}else{
			sale();
		}

	}

	private  static synchronized void sale() {
		while(tickets>0){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(Thread.currentThread().getName()+"卖出第"
				+(50-tickets+1)+"得票");
		tickets--;
		
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunableTest11 test11 = new RunableTest11();
		Thread t1 = new Thread(test11,"t1");
		Thread t2 = new Thread(test11,"t2");
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag=false;
		t2.start();
	}

}
