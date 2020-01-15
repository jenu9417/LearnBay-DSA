package com.jenu.lbdsa.t1.warmup1;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithSumZero {

	static boolean subArrayWithSumZeroExists(int[] arr) {
		final Set<Integer> sumSet = new HashSet<>();
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			if((arr[i] == 0) || (sum == 0) || (sumSet.contains(sum))) {
				return true;
			}
			sumSet.add(sum);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 4, -2, -2, 5, -2,  6 };
		System.out.println("SubArray with zero sum exists : " + subArrayWithSumZeroExists(arr));
	}
}
