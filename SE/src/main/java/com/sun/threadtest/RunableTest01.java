package com.sun.threadtest;

public class RunableTest01 implements Runnable {

	/*
	 * 1、start() 启动线程
	 * 2、currentThread()获取当前线程对象
	 * 3、getID()    获取当前线程ID  Thread-编号，编号从0开始
     * 4、getName()    获取当前线程名称
     * 5、sleep()    线程休眠
     * 6、stop()    停止线程（已过时，不建议使用）
     *  这些大部分都是静态方法，可以直接Thread.进行调用。
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+"第"+i+"次");
		
		}

	}

}
