package com.sun.thread;

import java.sql.Time;

class ObjectUtil {
    //看上去是单例模式，但是getObject方法并没有加线程同步，
//实际运行时有可能只创建一个，也有可能会创建出多个Object对象
    private static Object obj;

    public static Object getObject() {
        //
        if (null == obj) {
            obj = new Object();
            System.out.println(obj.hashCode());
        }else{
            System.out.println(obj.hashCode());
        }

        return obj;

    }

}


public class Main extends Thread {


    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {

            new Main().start();

        }

    }


    public void run() {

        for (int i = 0; i < 100; i++) {

            ObjectUtil.getObject();

        }

    }

}
