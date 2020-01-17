package com.jenu.lbdsa.t2.stack;

/*

 Dynamic Stack:
 
 Create a dynamic stack, which increases its size

 */
public class DynamicStack {
	
	private int[] data;
	
	private int top;
	
	private double threshold;
	
	private double shrinkThreshold;
	
	private static final int DEFAULT_SIZE = 10;
	
	private static final int MAX_SIZE = 1000;
	
	public DynamicStack(int size) {
		data = new int[size];
		top = -1;
		threshold = 0.75;
		shrinkThreshold = 0.1;
	}
	
	public void push(int n) throws Exception {
		if(shouldIncreaseCapacity()) {
			doubleCapacity();
		}
		data[++top] = n;
	}

	public int pop() throws Exception {
		if(shouldDecreaseCapacity()) {
			halfCapacity();
		}
		return data[top--];
	}

	public int peek() {
		return data[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == data.length-1);
	}
	
	private boolean shouldIncreaseCapacity() {
		if((data.length * threshold) < (top+1) && data.length < MAX_SIZE) {
			return true;
		}
		return false;
	}
	
	private void doubleCapacity() {
		int newSize = (data.length*2 > MAX_SIZE) ? MAX_SIZE : data.length*2;
		int[] newData = new int[newSize];
		System.arraycopy(data, 0, newData, 0, top+1);
		data = newData;
	}
	
	private boolean shouldDecreaseCapacity() {
		if(data.length > DEFAULT_SIZE && ((top-1) < (data.length*shrinkThreshold))) {
			return true;
		}
		return false;
	}

	private void halfCapacity() {
		int newSize = (data.length/2 < DEFAULT_SIZE) ? DEFAULT_SIZE : data.length/2;
		int[] newData = new int[newSize];
		System.arraycopy(data, 0, newData, 0, top+1);
		data = newData;
	}
	
	public void print() {
		int i = 0;
		System.out.print("Stack : [ ");
		while(i <= top) {
			System.out.print(data[i++] + "\t");
		}
		System.out.println(" ]");
	}
	
	public static void main(String[] args) throws Exception {
		final DynamicStack s = new DynamicStack(10);
		System.out.println("Initial Size : " + s.data.length);
		s.print();
		
		for(int i = 0; i<10; i++) {
			s.push(i);
		}
		System.out.println("Expanded Size : " + s.data.length);
		s.print();
		
		for(int i = 0; i<8; i++) {
			s.pop();
		}
		System.out.println("Shrinked Size : " + s.data.length);
		s.print();
	}


}
