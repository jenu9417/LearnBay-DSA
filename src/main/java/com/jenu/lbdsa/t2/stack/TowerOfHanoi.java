package com.jenu.lbdsa.t2.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*

Tower of Hanoi
--------------

Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is 
to move the entire stack to another rod, obeying the following simple rules:

1) Only one disk can be moved at a time.
2) Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack 
   i.e. a disk can only be moved if it is the uppermost disk on a stack.
3) No disk may be placed on top of a smaller disk.


Approach
--------

If we take the problem down to the lowest level, then it consists of swapping n disks from one rod to another.
Hence do the below steps:

swap (n-1) disks from source to intermediary
swap last disk from source to destination
swap (n-1) disks from intermediary to destination


Time  : O(2^n)
Space : O(n)

*/

public class TowerOfHanoi {
	
	Map<Integer,Stack<Integer>> stackMap = new HashMap<>();
	
	public TowerOfHanoi(int disks) {
		for(int i=1; i<=3; i++) {
			Stack<Integer> stack = new Stack<>();
			stackMap.put(i, stack);
		}
		
		for(int i=disks; i>0; i--) {
			stackMap.get(1).push(i);
		}
	}
	
	void swap(int disks, int srcRod, int dstRod) {
		if(disks == 1) {	
			Integer num = stackMap.get(srcRod).pop();
			stackMap.get(dstRod).push(num);
			System.out.printf("Swapped [ %d ] from R%d => R%d \n",num, srcRod, dstRod);
			return;
		}
		
		int intr = intermediary(srcRod, dstRod);
		swap(disks-1, srcRod, intr);
		swap(1, srcRod, dstRod);
		swap(disks-1, intr, dstRod);
	}
	
	int intermediary(int r1, int r2) {
		return (6-(r1+r2));
	}
	
	void printStack() {
		System.out.println("\n--------- Current Stack ---------\n");
		for(Map.Entry<Integer, Stack<Integer>> entry : stackMap.entrySet()) {
			System.out.printf("[ %d ]  ==> %s \n", entry.getKey(), entry.getValue().toString());
		}
		System.out.println("\n---------------------------------\n");
	}
	
	public static void main(String[] args) {
		int disks = 4;
		
		TowerOfHanoi th = new TowerOfHanoi(disks);
		th.printStack();
		
		th.swap(disks, 1, 3);
		
		th.printStack();
	}
}
