package com.jenu.lbdsa.t1.warmup1;

public class SpiralOrderMatrix {
	
	static void printSpiralOrderMatrix(int[][] matrix) {
		int tl = 0;
		int tr = 0;
		int bl = matrix.length-1;
		int br = matrix[0].length-1;
		
		while((tl <= bl) && (tr <= br)) {
			// Left to Right
			for(int i = tr; ((i <= br) && (tl <= bl)); i++) {
				System.out.println(matrix[tl][i]);
			}
			tl++;
			
			// Top to Bottom
			for(int i = tl; ((i <= bl) && (tr <= br)); i++) {
				System.out.println(matrix[i][br]);
			}
			br--;
			
			// Right to Left
			for(int i = br; ((i >= tr) && ((tl <= bl))); i--) {
				System.out.println(matrix[bl][i]);
			}
			bl--;
			
			// Bottom to Top
			for(int i = bl; ((i >= tl) && (tr <= br)); i--) {
				System.out.println(matrix[i][tr]);
			}
			tr++;
		}
	}
		
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },  { 9, 10, 11, 12 } };
		printSpiralOrderMatrix(matrix);
	}

}
