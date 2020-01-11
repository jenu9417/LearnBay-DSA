package com.jenu.lbdsa.t1.warmup2;

public class SwapThreeVariables {
	
	static void swap(int a, int b, int c) {
		System.out.printf("Before Swap ::  a = %d, b = %d, c = %d\n", a, b, c);
		
		// swap 'a' and 'b'
		a = a^b;
		b = a^b;
		a = a^b;
		
		// swap 'a' and 'c'
		a = a^c;
		c = a^c;
		a = a^c;
		
		System.out.printf("After Swap ::  a = %d, b = %d, c = %d\n", a, b, c);
	}
	
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c = 3;
		swap(a, b, c);
	}

}
