package com.sun.algorithm;
//递归函数
//递归的基本原理
//
//第一：每一级的函数调用都有自己的变量。
//
//第二：每一次函数调用都会有一次返回。
//
//第三：递归函数中，位于递归调用前的语句和各级被调用函数具有相同的执行顺序。
//
//第四：递归函数中，位于递归调用后的语句的执行顺序和各个被调用函数的顺序相反。
//
//第五：虽然每一级递归都有自己的变量，但是函数代码并不会得到复制。
public class Recursion {

	
	public static void main(String[] args) {
		int n = 4;
//		System.out.println("值为:"+number1(n));
		
//		System.out.println("青蛙跳"+n+"级台阶,大概有"+fun(n)+"种跳法");
		
		//累加函数，从1开始
//		System.out.println("从1到"+n+"累加之和为:"+accumulation(n));
		//求阶乘
		System.out.println("从1到"+n+"阶乘为:"+factorial(n));
	}
	
	/*
	 * 一组数，1,1,2,3,5,8....求第三十位数是多少
	 */
	//这个递归写错了，
	public static int number(int sum,int i){
		int item = 1;
		sum =sum+item;
		if(i>30)
			return sum;
		else 
			return number(sum,++i);
	}
	/*
	 * 一组数，1,1,2,3,5,8....求第三十位数是多少
	 */
//	第一要素：明确你这个函数想要干什么。先不管函数里面的代码什么，而是要先明白，你这个函数的功能是什么，要完成什么样的一件事。
//
//	第二要素：寻找递归结束条件。我们需要找出当参数为啥时，递归结束，之后直接把结果返回，请注意，这个时候我们必须能根据这个参数的值，能够直接知道函数的结果是什么。
//
//	第三要素：找出函数的等价关系式。我们要不断缩小参数的范围，缩小之后，我们可以通过一些辅助的变量或者操作，使原函数的结果不变。
//	number1(30)
	public static int number1(int i){
		if(i == 1 ||i == 2){
			return 1;
		}else{
			return number1(i-1) + number1(i-2);
		}
		
	}
	//小青蛙跳台阶,一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法
	public static int fun(int n){
		//退出递归条件
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		//等价关系式
		return fun(n-1)+fun(n-2);
		
	}
       //累加函数,从1开始
	  public static int accumulation(int n){
		  if(n == 1){
			  return 1;
		  }
		  return n + accumulation(n-1);
	  }
	  //求阶乘
	  public static int factorial(int n){
		  if(n == 1){
			  return 1;
		  }
		  return n*factorial(n-1);
	  }
}
