package com.jenu.lbdsa.t1.warmup1;

import java.util.Arrays;

/*

Find maximum Product of two integers in an array
Input : -10, -3, 5, 6, -2
output : -10 and -3

*/

public class MaxProductOfTwoIntegers {
	
	static int findMaxProduct(int[] arr) {
		int len = arr.length;
		if(len < 3) {
			return arr[0] * arr[1];
		}
		Arrays.sort(arr);
		int max1 = arr[0] * arr[1];
		int max2 = arr[len-1] * arr[len-2];
		
		return (max1 > max2) ? max1 : max2;
	}
	
	public static void main(String[] args) {
		int[] arr = { -10, -3, 5, 6, -2 };
		int max = findMaxProduct(arr);
		System.out.println("Max Product : " + max);
	}

}
