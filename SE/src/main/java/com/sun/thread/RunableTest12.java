package com.sun.thread;


public class RunableTest12 implements Runnable {

	private int tickets = 50;

	private Object object = new Object();

	private static boolean flag = true;

	public void run() {
		// TODO Auto-generated method stub
		if (flag) {
			while (tickets > 0) {
				synchronized (object) {
					flag = false;
					System.out.println(Thread.currentThread().getName() + "获取了object锁");
					try {
						Thread.sleep(50000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					synchronized (this) {
						System.out.println(Thread.currentThread().getName() + "卖了第" + (50 - tickets + 1) + "张票");
						tickets--;
					}
				}

			}
		} else {
			sale();
		}
	}

	private synchronized void sale() {
		// TODO Auto-generated method stub
		flag = true;
		System.out.println(Thread.currentThread().getName() + "获取了this锁");
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (object) {
			System.out.println(Thread.currentThread().getName() + "卖了第" + (50 - tickets + 1) + "张票");
			tickets--;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunableTest12 test12 = new RunableTest12();
		Thread t1 = new Thread(test12, "t1");
		Thread t2 = new Thread(test12, "t2");
		t1.start();
		t2.start();
	}

}
