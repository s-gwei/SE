package com.sun.threadtest;



public class Main {
	
	
	public static void main(String[] args) {
		
		RunableTest01 runableTest01 = new RunableTest01();
		Thread thread01 = new Thread(runableTest01,"线程A");
		Thread thread02 = new Thread(runableTest01,"线程B");
	    //t1start之后，执行t1.join会将main线程挂起，等t1执行完毕在执行main，这样main线程就不能执行t2.start,
		//所以先打印t1在打印t2,join是挂起主线程，对其他线程如果已经start，则没有影响
//		thread01.start();
//		thread02.start();
//		thread01.join();
//		for(int i=0;i<10;i++){
//			Thread.sleep(10);
//			System.out.println(Thread.currentThread().getName()+"第"+i+"次");
//		}
		
		
		Main main = new Main();
//		
		RunableTest02  test09 = main.new  RunableTest02() ;
		Thread t1 = new Thread(test09,"t1");
		Thread t2 = new Thread(test09,"t2");
		t1.start();
		t2.start();
		
		
	}

	
	/*
     * 多线程如果不对都使用的变量同步，会造成数据错乱，出现线程安全问题
     */
	
	
	class RunableTest02 implements Runnable {
		 int tickets = 5;
	    Object obj = new Object();//锁的对象，可以是任意的对象
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
//			sale();
			System.out.println("此时执行的线程是："+Thread.currentThread().getName());
			//实现两个线程交替打印，
			   while(tickets>0){
				   try {
//					Thread.sleep(10);//让线程重新回到可执行态，争抢时间片，但是不释放锁
//					Thread.yield();//让线程重新回到可执行态，争抢时间片
					wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   synchronized (obj) {
		        	System.out.println(Thread.currentThread().getName()+"卖了第"+(5-tickets+1)
		        			+"张票");
		        	tickets--;
				   }
		        }
		}
		
		
//		private synchronized void sale() {
//			// TODO Auto-generated method stub
//			 while(tickets>0){
//				  
//		        	System.out.println(Thread.currentThread().getName()+"卖了第"+(50-tickets+1)
//		        			+"张票");
//		        	tickets--;
//				   
//		        }
//		}
		
	}
}
