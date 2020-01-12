package com.jenu.lbdsa.t1.warmup2;

public class FlipBits {
	
	static int flipBits(int num) {
		int n = num;
		int count = 0;
		while(n>0) {
			count++;
			n=n>>1;
		}
		
		int k = (int) Math.pow(2, count);
		
		return (k-1)^num;
	}
	
	public static void main(String[] args) {
		int flip = flipBits(10);
		System.out.println("Flip number of 10 is" + flip);
	}

}
