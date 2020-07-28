package com.sun.thread;

public class RunableTest09 implements Runnable {
    /*
     * 多线程如果不对都使用的变量同步，会造成数据错乱，出现线程安全问题
     */
    private int tickets = 5;
	public void run() {
		// TODO Auto-generated method stub
        while(tickets>0){
        	System.out.println(Thread.currentThread().getName()+"卖了第"+(5-tickets+1)
        			+"张票");
        	tickets--;
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunableTest09  test09  = new RunableTest09();
		Thread t1 = new Thread(test09,"t1");
		Thread t2 = new Thread(test09,"t2");
		t1.start();
		t2.start();
	}

}
