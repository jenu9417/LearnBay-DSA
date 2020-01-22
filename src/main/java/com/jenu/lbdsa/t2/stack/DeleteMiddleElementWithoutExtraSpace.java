package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

public class DeleteMiddleElementWithoutExtraSpace {
	
	static void deleteMiddleElement(Stack<Integer> stack, int i, int size) {
		if(stack.isEmpty()) {
			return;
		}
		Integer top = stack.pop();
		deleteMiddleElement(stack, i-1, size);
		if((size-1)/2 != i) {
			stack.push(top);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		
		System.out.println("Before Middle Element Removal : " + stack.toString());
		deleteMiddleElement(stack, (stack.size()-1), stack.size());
		System.out.println("After Middle Element Removal : " + stack.toString());
	}
	
}
