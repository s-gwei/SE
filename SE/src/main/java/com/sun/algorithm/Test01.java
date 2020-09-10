package com.sun.algorithm;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Test01 {

	/*
	 * 部门优化问题
	 * 这是一个循环排序问题， 目前还有问题，就是两个组项目人数相同且都是最大时，
	 * 我目前的处理是如果两个组人数相同选择右边的，这里需求没有说明，需要优化
	 * 
	 */

	@Test
	public void test01() {
		// 初始化四个项目组人数
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 10);
		map.put("B", 7);
		map.put("C", 5);
		map.put("D", 3);
		//list用来排序
		int[] list = { 10, 7, 5, 3 };
		// 每个月调整一次，10年120次
		for (int i = 0; i < 120; i++) {
			// 将项目组人数排序，升序，最右边是最大的，
			sort(list);
			// 将项目组人数进行调整，
			for (String key : map.keySet()) {
				if (map.get(key) == list[3]) {
					map.put(key, list[3] - 3);
					continue;
				}
				if (map.get(key) == list[2]) {
					map.put(key, list[2] + 1);
					continue;
				}
				if (map.get(key) == list[1]) {
					map.put(key, list[1] + 1);
					continue;
				}
				if (map.get(key) == list[0]) {
					map.put(key, list[0] + 1);
					continue;
				}
			}
			//将list数组也进行调整
			list[3] = list[3] - 3;
			list[2] = list[2] + 1;
			list[1] = list[1] + 1;
			list[0] = list[0] + 1;
			//
		}
		// 最后遍历map
		for (Object key : map.keySet()) {
			System.out.println(key + ";" + map.get(key));
		}
		 System.out.println("最后结果是:"+list[0]+";"+list[1]+";"+list[2]+";"+list[3]+";");
	}

	// 冒泡排序
	private void sort(int[] list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.length; i++) {
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < list[i]) {
					int temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
		System.out.println(list[0] + ";" + list[1] + ";" + list[2] + ";" + list[3] + ";");
	}
}
