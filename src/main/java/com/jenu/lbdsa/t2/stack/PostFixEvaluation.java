package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

/*

Postfix Evaluation:
-------------------

Find the integer equivalent of a postfix expression.

Approach:
---------
Iterate through tokens in the expression. If :

a) Number : Push to stack.
b) Operator : Pop the number of operands from stack and push the result to stack.

Finally pop out the remaining element from the stack.


Time  : O(n)
Space : O(n)

*/

public class PostFixEvaluation {
	
	static int evaluatePostFix(String expr) {
		String[] tokens = expr.split(" ");
		Stack<Integer> numStack = new Stack<>();
		for(String token : tokens) {
			Integer num = parseNum(token);
			if(num != null) {
				numStack.push(num);
				continue;
			}
			
			Integer op1 = numStack.pop();
			Integer op2 = numStack.pop();
			
			switch(token) {
			case "/":
				numStack.push(op2/op1);
				break;
			case "*":
				numStack.push(op2*op1);
				break;
			case "+":
				numStack.push(op2+op1);
				break;
			case "-":
				numStack.push(op2-op1);
				break;
			}
		}
		
		return numStack.pop();
	}
	
	static Integer parseNum(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		String expr = "2 3 1 * + 9 -";
//		String expr = "5 10 2 * + 3 -";
		int value = evaluatePostFix(expr);
		System.out.println("Postfix value : " + value);
	}

}
