package com.sun.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Runningsum {

	/**
	 * 
	 * @param nums
	 * @return 动态和
	 */
	// @Test
	public int[] sum(int[] nums) {
		int[] runningsum = new int[nums.length];
		if (nums.length == 1) {
			return nums;
		}
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = 0; j <= i; j++) {
				sum = sum + nums[j];
			}
			runningsum[i] = sum;
		}
		return runningsum;

	}

	/**
	 * 好数对
	 */
	public int numIdenticalPairs(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					count++;
				}
			}
		}
		return count;

	}

	/**
	 * 拥有最多数目糖果的孩子
	 * 
	 */
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> list = new ArrayList<Boolean>(candies.length);
		for (int i = 0; i < candies.length; i++) {
			int flag = 0;
			for (int j = 0; j < candies.length; j++) {
				if (candies[i] + extraCandies < candies[j]) {
					flag++;
				}
			}
			if (flag == 0) {
				list.add(true);
			} else {
				list.add(false);
			}
		}
		return list;

	}

	/**
	 * 统计作战单位 int[] rating
	 */
	@Test
	public void numTeams() {
		int[] rating = { 2, 5, 3, 4, 1 };
		int count = 0;
		// if(rating.length<3){
		// return 0;
		// }
		for (int x = 0; x < rating.length - 2; x++) {
			for (int y = x + 1; y < rating.length - 1; y++) {
				for (int z = y + 1; z < rating.length; z++) {
					if (rating[x] < rating[y] && rating[y] < rating[z]) {
						count++;
					}
					if (rating[x] > rating[y] && rating[y] > rating[z]) {
						count++;
					}
				}
			}
		}
		System.out.println(count);

	}

	public List<List<Integer>> combinationSum2() {

		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		return null;

	}
}
