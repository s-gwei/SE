package com.sun.thread;

public class RunableTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1、start() 启动线程
		 * 2、currentThread()获取当前线程对象
		 * 3、getID()    获取当前线程ID  Thread-编号，编号从0开始
         * 4、getName()    获取当前线程名称
         * 5、sleep()    线程休眠
         * 6、stop()    停止线程（已过时，不建议使用）
         *  这些大部分都是静态方法，可以直接Thread.进行调用。
		 */
		RunableTest04 runableTest04 = new RunableTest04();
		Thread  thread = new Thread(runableTest04,"A");
		thread.start();
		for(int i = 0;i < 20; i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("id:"+Thread.currentThread().getId()+";"+"name:"+Thread.currentThread().getName()+";"+i);
		}
	}

}

class RunableTest04 implements Runnable{
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 20; i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("id:"+Thread.currentThread().getId()+";"+"name:"+Thread.currentThread().getName()+";"+i);
			
		}
	}
	
}