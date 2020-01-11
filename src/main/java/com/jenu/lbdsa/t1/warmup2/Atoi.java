package com.jenu.lbdsa.t1.warmup2;

public class Atoi {
	
	static int atoi(String str) {
		if(str == null || str.trim().equals("")) {
			return 0;
		}
		boolean isNegative = false;
		int index = 0;
		
		if(str.charAt(0) == '-') {
			index++;
			isNegative = true;
		} else if(str.charAt(0) == '+') {
			index++;
		}
		
		int num = 0;
		while(index < str.length()) {
			if(str.charAt(index) > '0' && str.charAt(index) < '9') {
				num = (num*10) + (str.charAt(index) - '0');
			} else {
				return 0;
			}
			index++;
		}
		
		if(isNegative) {
			return -1*num;
		}
		
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println(atoi("6567"));
		System.out.println(atoi("-6567"));
		System.out.println(atoi(" "));
		System.out.println(atoi("abc"));
	}

}
