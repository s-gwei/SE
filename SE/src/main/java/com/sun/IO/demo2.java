package com.sun.IO;

import java.math.BigDecimal;

public class demo2 {

//	'''基本类型的参数传递'''
    public static void testBasicType(int m) {
        System.out.println("m=" + m);//m=50
        m = 100;
        System.out.println("m=" + m);//m=100
    }
//   '''参数为对象，不改变引用的值'''
//   '''s即sMain指向的对象执行了append方法，在原来的字符串上加了段“_add”'''

    public static void add(StringBuffer s) {
        s.append("_add");
    }

//    '''参数为对象，改变引用的值 '''
//    '''引用变量指向了一个新的对象，已经不是sMain指向的对象了'''
    public static void changeRef(StringBuffer s) {
        s = new StringBuffer("Java");
    }
    //验证引用类型是引用传递
    public static void check(){
    	 StringBuffer s1 = new StringBuffer("s1");
         StringBuffer s2=s1;
         System.out.println(s1.toString());
         s2.append("s2");
         System.out.println(s1);
    }
    public static void main(String[] args) {
     /*   int i = 50;
        testBasicType(i);
        System.out.println("i="+i);//'''i=50'''
        StringBuffer sMain = new StringBuffer("init");
        System.out.println("sMain=" + sMain.toString());//'''sMain=init'''
        add(sMain);
        System.out.println("sMain=" + sMain.toString());//'''sMain=init_add'''
        changeRef(sMain);
        System.out.println("sMain=" + sMain.toString());//'''sMain=Java'''
*/        
    	
//        check();
        number();
    }
	//double精度计算问题
    public static void number(){
    	String a = "99999999999999999999";
    	double b = Double.parseDouble(a);
    	BigDecimal c = new BigDecimal("99999999999999999999");
    	BigDecimal d = new BigDecimal("10000000000000000000");
    	BigDecimal e = d.divide(c,2,BigDecimal.ROUND_HALF_UP);
    	System.out.println(e);
    	String str = " hello world ";
    	String str1 = str.trim();
    	String str2 = str.replace("world", "China");
    	System.out.println(str1);
    	System.out.println(str);
    	System.out.println(str2);
    }

}
