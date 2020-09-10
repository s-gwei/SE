package com.sun.thread;

public class RunableTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runabletest02 runabletest02 = new Runabletest02();
		Thread thread = new Thread(runabletest02, "runabletest02");
		thread.start();
		for (int i = 0; i < 2000; i++) {
			System.out.println(Thread.currentThread().getName() + "第" + i + "次");
		}
	}

}

class Runabletest02 implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2000; i++) {
			System.out.println(Thread.currentThread().getName() + "第" + i + "次");
		}
	}

}