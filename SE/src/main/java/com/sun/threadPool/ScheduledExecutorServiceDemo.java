package com.sun.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author eshore
 *定时线程池，该线程池可用于周期性地去执行任务，通常用于周期性的同步数据。
 *scheduleAtFixedRate:是以固定的频率去执行任务，周期是指每次执行任务成功执行之间的间隔。
 *schedultWithFixedDelay:是以固定的延时去执行任务，
 *延时是指上一次执行成功之后和下一次开始执行的之前的时间。
 */
public class ScheduledExecutorServiceDemo {

	   public static void main(String args[]) {

	        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
	        ses.scheduleAtFixedRate(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    Thread.sleep(4000);
	                    System.out.println(Thread.currentThread().getId() + "执行了");
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }, 0, 2, TimeUnit.SECONDS);
	    }
}
