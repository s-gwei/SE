package com.sun.thread;

public class RunableTest05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * join的作用就是让其他线程变为等待。
         * 一个A线程，一个B线程，A线程调用B线程的join方法，那么A等待B执行完毕后，释放CPU执行权，再继续执行。
         * 有这样一个题目：T1,T2,T3三个线程，怎么保证T2在T1完成后执行，T3在T2完成后执行？？？
         * 在T3的run方法中调用T2的join方法，在T2的run方法中调用T1的join方法
		 */
		
		
		/*
		 * 如果一个线程A执行了thread.join()语句，其含义是：当前线程A等待thread线程终止后才从thread方法返回。
		 * 注意这里是线程A执行了A.join,线程A是当前线程，如果在main函数中执行A.join，其实是将main线程挂起，
		 * 等待A线程执行完毕后，再执行main线程。
		 */
		RunableTset06  runableTset06 = new RunableTset06();
		Thread  t1 = new Thread(runableTset06,"A");
		Thread  t2 = new Thread(runableTset06,"B");
		Thread  t3 = new Thread(runableTset06,"c");
		//直接执行t1.start再执行t2start，交替打印
//		t1.start();
//		t2.start();
//		t3.start();
	    //t1start之后，执行t1.join会将main线程挂起，等t1执行完毕在执行main，这样main线程就不能执行t2.start,
		//所以先打印t1在打印t2
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t3.start();
		//执行t1,t2start之后，main线程挂起，不会影响t1t2打印，t1t2是交替打印
/*		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}

class RunableTset06 implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i < 20 ; i++){
			System.out.println(Thread.currentThread().getName());
		}
	
	}
	
}