package com.jenu.lbdsa.t92.backtracking;

import java.util.Arrays;

/**
 * +-----------------+
 * | NQueens Problem |
 * +-----------------+
 * Classic backtracking problem.
 * There are 'N' queens provided and we have to place each of them in an NxN chessboard
 * such that none of them are in attacking position to one another.
 * 
 * 2 Queens are said to be in an attacking position, if they are placed:
 * a) in the same horizontal row
 * b) in the same vertical column
 * c) they are diagonal
 * 
 * In order to find whether they are vertical, we could make use of the fact that,
 * "Slope of a diagonal will be Abs(1)"
 * It can be calculated by (Y2 - Y1) / (X2 - X1). (or)  (Y2-Y1) = (X2-X1)
 *
 *
 * Time  :  O(N^N)
 *
 * @author Janardhanan V S
 *
 */
public class NQueensProblem {

	static boolean placeQueen(int current, int n, int[] solution) {
		boolean placed = false;
		if(current == n) {
			return true;
		}
		
		for(int i=0; i<n; i++) {
			if(isValidPosition(current, i, solution)) {
				solution[current] = i;
				placed = placeQueen(current+1, n, solution);
			}
			if(!placed) {
				solution[current] = -1;
			}
		}
		return placed;
	}
	
	static boolean isValidPosition(int x, int y, int[] solution) {
		for(int i=0; i<solution.length; i++) {
			if(solution[i] == -1) {
				continue;
			}
			if((x == i) || (y == solution[i]) || Math.abs(x-i) == Math.abs(y-solution[i])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] result = new int[n];
		Arrays.fill(result, -1);
		placeQueen(0, n, result);
		System.out.println("Place the queens at : ");
		int k=0;
		for(int i=0; i<n; i++) {
			System.out.print("[\t");
			for(int j=0; j<n; j++) {
				if(i==k && j==result[k]) {
					System.out.print("1\t");
					k++;
				} else {
					System.out.print(".\t");
				}
			}
			System.out.println("]");
		}
	}
	
}
