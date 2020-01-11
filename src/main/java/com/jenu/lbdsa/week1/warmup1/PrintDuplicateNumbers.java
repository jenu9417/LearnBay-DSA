package com.jenu.lbdsa.week1.warmup1;

public class PrintDuplicateNumbers {
	
	static void printDuplicate(int[] arr, int limit) {
		int[] lookup = new int[limit+1];
		for(int i=0;i<arr.length;i++) {
			lookup[arr[i]]++;
		}
		for(int i=0;i<lookup.length;i++) {
			if(lookup[i] > 1) {
				System.out.println(lookup[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 1,2,2,2,2,4,5,7,8,8  };
		printDuplicate(arr, 10);
	}

}
