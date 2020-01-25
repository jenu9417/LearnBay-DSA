package com.jenu.lbdsa.t2.stack;

import java.util.Stack;

/*

Infix To Postfix Conversion
---------------------------

Post fix is the notation, where operator comes after the operands.

Approach:
---------
Append the operands onto a string.
Keep a stack for operators. When a new operator is encountered

a) if '(', push to stack.
b) if ')', pop out everything until '('.
c) if others, follow the rule that, a lower precedence operator should not come on top of stack. Hence pop out.
   if same precedence, pop out and push the new one.
   
Time  : O(n)
Space : O(n)

*/

public class InfixToPostFixConversion {

	static String convertInfixToPostfix(String expr) {
		String[] tokens = expr.split(" ");
		StringBuffer strBuf = new StringBuffer();
		Stack<String> operatorStack = new Stack<>();
		String operator = "";
		
		for(String token : tokens) {
			switch(token) {
			
			case "(":
				operatorStack.push("(");
				break;
				
			case ")":
				while(!operatorStack.isEmpty() && !("(").equals(operator = operatorStack.pop())) {
					strBuf.append(operator);
				}
				break;
			
			case "/":
			case "*":
				if(("/").equals(operatorStack.peek()) || ("*").equals(operatorStack.peek())) {
					operator = operatorStack.pop();
					strBuf.append(operator);
				}
				operatorStack.push(token);
				break;
			
			case "+":
			case "-":
				while(!operatorStack.isEmpty() && !("(").equals(operatorStack.peek())) {
					operator = operatorStack.pop();
					strBuf.append(operator);
				}
				operatorStack.push(token);
				break;
				
			default:
				strBuf.append(token);
				break;
			}
		}
		
		while(!operatorStack.isEmpty()) {
			strBuf.append(operatorStack.pop());
		}
		
		return strBuf.toString();
	}
	
	public static void main(String[] args) {
		//String infix = "( A + B ) + ( C - D )";
		String infix = "A + B / D - C * D - ( E + F )";
		String postfix = convertInfixToPostfix(infix);
		System.out.printf("Infix Expression : %s\n", infix);
		System.out.printf("Postfix Expression : %s\n", postfix);
	}
	
	
	
}
