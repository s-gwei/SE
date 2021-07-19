package com.sun.algorithm;



public class Test02 {
	
	/**
	 * 邀请码检测问题
	 * 先将16位字符串翻转，再分割成16个字符
	 * 循环匹配，求取
	 */
	

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

	private int number(String str) {
		// TODO Auto-generated method stub
		int result = 0;
		if ("a".equals(str) || "j".equals(str) || "s".equals(str)) {
			result = 1;
		} else if ("b".equals(str) || "k".equals(str) || "t".equals(str)) {
			result = 2;
		} else if ("c".equals(str) || "l".equals(str) || "u".equals(str)) {
			result = 3;
		} else if ("d".equals(str) || "m".equals(str) || "v".equals(str)) {
			result = 4;
		} else if ("e".equals(str) || "n".equals(str) || "w".equals(str)) {
			result = 5;
		} else if ("f".equals(str) || "o".equals(str) || "x".equals(str)) {
			result = 6;
		} else if ("g".equals(str) || "p".equals(str) || "y".equals(str)) {
			result = 7;
		} else if ("h".equals(str) || "q".equals(str) || "z".equals(str)) {
			result = 8;
		} else if ("i".equals(str) || "r".equals(str)) {
			result = 9;
		}
		if(result == 0){
			result = Integer.parseInt(str);
		}
		return result;
	}

}
