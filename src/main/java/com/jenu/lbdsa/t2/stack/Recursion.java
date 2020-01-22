package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

/*

 Recursion
 ---------
 
 Recursion is actually a function calling itself to do some repetitive tasks
 A recursion should have an exit condition as mandatory.
 
 Two Types:
 ----------
 
 a) Head Recursion:
 ------------------
 When we first recurse and reach the innermost element and then process from there.
 Leaf to Root.
 
 5, 4, 3, 2, 1
 
 b) Tail Recursion:
 ------------------
 When we first process then recurse till the innermost.
 Root to Leaf.

 1, 2, 3, 4, 5

 */

public class Recursion {
	
	// recurse first, then process
	static void headRecursion(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		Integer top = stack.pop();
		headRecursion(stack);
		System.out.print(top + "\t");		
	}
	
	// process first, then call recursion
	static void tailRecursion(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		
		Integer top = stack.pop();
		System.out.print(top + "\t");
		tailRecursion(stack);
	}
	
	public static void main(String[] args) {

		Stack<Integer> stack = getStack();
		
		System.out.println("Stack : " + stack.toString());
		System.out.println();
		
		System.out.print("Head Recursion : ");
		headRecursion(stack);
		System.out.println("\n");
		
		stack = getStack();
		
		System.out.print("Tail Recursion : ");
		tailRecursion(stack);
		System.out.println("\n");
	}
	
	static Stack<Integer> getStack() {
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);
		
		return stack;
	}

}
