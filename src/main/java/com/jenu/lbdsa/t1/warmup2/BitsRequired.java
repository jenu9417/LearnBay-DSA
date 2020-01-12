package com.jenu.lbdsa.t1.warmup2;

// approach: Count the number of digits by right-shift. 2^(numOfDigit)
public class BitsRequired {
	
	static int bitsRequired(int number) {
		int count = 0;
		while(number >= 1) {
			number = number>>1;
			count++;
		}
		
		return count;	
	}

	public static void main(String[] args) {
		int bits = bitsRequired(10);
		System.out.println("Bits required for 10 is : " + bits);
	}
	
}
