package com.jenu.lbdsa.t1.warmup2;

// approach: Count the number of digits by right-shift. 2^(numOfDigit)
public class FindSignificantBit {
	
	static int signficantDigit(int number) {
		int count = 0;
		while(number >= 1) {
			number = number>>1;
			count++;
		}
		
		return count;	
	}

	public static void main(String[] args) {
		int msb = signficantDigit(10);
		System.out.println("MSB of 10 is at : " + msb);
	}
	
}
