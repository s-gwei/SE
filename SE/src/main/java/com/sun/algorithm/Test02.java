package com.sun.algorithm;

import org.junit.Test;

public class Test02 {
	
	/**
	 * 邀请码检测问题
	 * 先将16位字符串翻转，再分割成16个字符
	 * 循环匹配，求取
	 */
	
	@Test
	public void test02(){
		String test = "12345678abcdefgh";
		StringBuffer stringBuffer = new StringBuffer(test);
		String str = new String(stringBuffer.reverse());
		String[] string = str.split("");
		int Oddnumber = 0;
        int evennumbers = 0;
		for(int i=0;i<string.length;i++){
			if(i%2 == 0){
				//根据条件将字符匹配成数字
				Oddnumber = Oddnumber+number(string[i]);
			}else{
				//根据条件将字符匹配成数字
				int a = number(string[i])*2;
				if(a/10 == 1){
					a = a-9;
				}
				evennumbers = evennumbers+a;
			}
		}
		int count = Oddnumber+evennumbers;
		if(count % 10 == 0){
			System.out.println("OK");
		}else{
			System.out.println("error");
		}
	}

	private int number(String string) {
		// TODO Auto-generated method stub
		int result = 0;
		switch(string){
		   case "a":
		   case "j":
		   case "s":
			   result=1;
			   break;
		   case "b":
		   case "k":
		   case "t":
			   result=2;
			   break;
		   case "c":
		   case "l":
		   case "u":
			   result=3;
			   break;
		   case "d":
		   case "m":
		   case "v":
			   result=4;
			   break;
		   case "e":
		   case "n":
		   case "w":
			   result=5;
			   break;
		   case "f":
		   case "o":
		   case "x":
			   result=6;
			   break;
		   case "g":
		   case "p":
		   case "y":
			   result=7;
			   break;
		   case "h":
		   case "q":
		   case "z":
			   result=8;
			   break;
		   case "i":
		   case "r":
			   result=9;
			   break;
			default:
				break;
				
		}
		if(result == 0){
			result = Integer.parseInt(string);
		}
		return result;
	}

}
