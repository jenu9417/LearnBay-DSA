package com.jenu.lbdsa.t2.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/*

MaxFrequency Stack:
-------------------

A stack which return the most frequent element in the stack. If there are elements with same frequency, 
it should return in LIFO order.

Time  : O(n)
Space : O(n)

*/

public class MaxFrequencyStack {
	
	private Map<Integer, Stack<Integer>> bucketMap;
	
	private Map<Integer, Integer> frequencyMap;
	
	private int topBucket;
	
	public MaxFrequencyStack() {
		bucketMap = new TreeMap<>();
		frequencyMap = new HashMap<>();
		topBucket = -1;
	}
	
	public void push(Integer num) {
		// Update frequency
		Integer frequency = frequencyMap.get(num);
		if(frequency == null) {
			frequency = 1;
		} else {
			frequency++;
		}
		frequencyMap.put(num, frequency);
		
		// Update bucket
		Stack<Integer> bucket = bucketMap.get(frequency);
		if(bucket == null) {
			bucket = new Stack<>();
		}
		bucket.push(num);
		bucketMap.put(frequency, bucket);
		
		// Update topBucket
		if(frequency > topBucket) {
			topBucket = frequency;
		}
	}
	
	public Integer pop() {
		// Update bucket
		Stack<Integer> bucket = bucketMap.get(topBucket);
		if(bucket == null) {
			return null;
		}
		Integer num = bucket.pop();
		if(bucket.isEmpty()) {
			bucketMap.remove(topBucket);
			topBucket--;
		} else {
			bucketMap.put(topBucket, bucket);
		}
		
		// Update frequency
		Integer frequency = frequencyMap.get(num);
		if(frequency != null) {
			frequency--;
			frequencyMap.put(num, frequency);
		}
		
		return num;
	}
	
	public Integer peek() {
		Stack<Integer> bucket = bucketMap.get(topBucket);
		if(bucket == null) {
			return null;
		}
		return bucket.peek();
	}
	
	public void printStack() {
		System.out.println("\n--------- Current Stack ---------\n");
		for(Map.Entry<Integer, Stack<Integer>> entry : bucketMap.entrySet()) {
			System.out.printf("[ %d ]  ==> %s \n", entry.getKey(), entry.getValue().toString());
		}
		System.out.println("\n---------------------------------\n");
	}
	
	public static void main(String[] args) {
		MaxFrequencyStack mfStack = new MaxFrequencyStack();
		mfStack.push(1);
		mfStack.push(2);
		mfStack.push(2);
		mfStack.push(2);
		mfStack.push(3);
		mfStack.push(3);
		mfStack.push(4);
		
		System.out.println("Peek : " + mfStack.peek());
		mfStack.printStack();
		
		mfStack.pop();
		mfStack.pop();
		mfStack.push(4);
		mfStack.push(4);
		mfStack.push(4);
		
		System.out.println("Peek : " + mfStack.peek());
		mfStack.printStack();
	}

}
