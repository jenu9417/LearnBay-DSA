package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

/*

ValidateStackSequences
----------------------

Given two arrays containing push operations and pop operations, find if these are valid stack operations.

pushed = { 1, 2, 3, 4, 5 };
popped = { 4, 5, 3, 2, 1 };

This is valid, since all the operations can be performed in order using stack.

pushed = { 1, 2, 3, 4, 5 };
popped = { 4, 3, 5, 1, 2 };

This is not valid, since there comes a point where you have push 2 after 1, but you are required to pop 1
before 2, which cannot be possible.


Approach:
---------
This is similiar to the merge portion of merge sort, or the train scheduling problem.
Basically, iterate over the two arrays and do the valid stack operations, by pushing and popping.
If there comes a point, where you cannot perform an action, or finally the stack is not empty, then
invalid. Else valid.

Time  : O(n)
Space : O(n)

*/

public class ValidateStackSequences {
	
	static boolean validateStackSequences(int[] pushed, int[] popped) {

		Stack<Integer> stack = new Stack<>();
		boolean validSequence = true;
		int i=0;
		int j=0;
		
		while(true) {
			if((stack.isEmpty() || !stack.peek().equals(popped[j])) && i<pushed.length) {
				stack.push(pushed[i]);
				i++;
				continue;
			} else if(!stack.isEmpty() && stack.peek().equals(popped[j]) && j<pushed.length) {
				stack.pop();
				j++;
				continue;
			} else if(stack.isEmpty() && i == pushed.length && j==popped.length) {
				break;
			}
			validSequence = false;
			break;
		}		
		
		return validSequence;
    }
	
	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 5, 3, 2, 1 };
//		int[] popped = { 4, 3, 5, 1, 2 };
		boolean isValid = validateStackSequences(pushed, popped);
		System.out.println("Valid Sequence : " + isValid);
	}

}
