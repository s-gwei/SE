package com.sun.algorithm;



public class Test03 {
	
	/**
	 * 游戏币取值问题
	 * 这个问题很像数学里的三元一次方程，
	 * x+y+z = n
	 * x+2y+5z = m
	 * 只要满足y+4z=m-n,且y+z<=n等式成立就是一种方法，y和z均为整数n
	 * 
	 */
	
//	int n, int m

	public void tset03(){
    	int n = 7;
    	int m = 35;
    	if(n>m){
    		System.out.println("游戏币面值不能小于个数");
    	}
		int s = m-n;
		int count=0;
		for(int i=s;i>=0;i--){
			for(int j=0;j<=s;j++){
				if(i+4*j == s && i+j<=n){
					count++;
					continue;
				}
			}
		}
		System.out.println(n+"个游戏币总面值为"+m+",一共有"+count+"种组合");
	}
}
