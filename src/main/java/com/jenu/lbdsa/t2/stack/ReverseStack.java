package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

/*

Stack Reversal:
---------------

Two Approaches:

a) Use three stacks and transfer the elements in between them a->b->c->a.
Time Complexity : O(n)
Space Complexity : O(n)

b) Use recursion and store the popped element in the stack-frame, pop out till the last
 and then push each element to the bottom, in turn, popping all first and then pushing
 in the process, in turn using the stack-frame again.
 Time Complexity : O(n^2)
 Space Complexity : O(n)

*/

public class ReverseStack {
	
	static void reverseStack(Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		}
		
		int num = s.pop();
		reverseStack(s);
		pushToBottom(num, s);
	}
	
	static void pushToBottom(int num, Stack<Integer> s) {
		if(s.isEmpty()) {
			s.add(num);
			return;
		}
		
		int top = s.pop();
		pushToBottom(num, s);
		s.push(top);
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
		System.out.println("Before Reversal : " + s.toString());
		reverseStack(s);
		System.out.println("After Reversal : " + s.toString());
	}

}
