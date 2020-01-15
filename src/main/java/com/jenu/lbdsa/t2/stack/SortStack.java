package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

/*

Sorting a Stack
---------------

Basically the same idea as stack reversal. Just that, while re-inserting, check if stack is empty or the top
element is less than or equal to.

*/

public class SortStack {
	
	static void sortStack(Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		}
		int num = s.pop();
		sortStack(s);
		pushToSortedStack(num, s);
	}
	
	static void pushToSortedStack(int num, Stack<Integer> s) {
		if(s.empty() || s.peek().compareTo(num) != 1) {
			s.push(num);
			return;
		}
		
		int top = s.pop();
		pushToSortedStack(num, s);
		s.push(top);
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		
		System.out.println("Before Sorting : " + s.toString());
		sortStack(s);
		System.out.println("After After : " + s.toString());
	}

}
