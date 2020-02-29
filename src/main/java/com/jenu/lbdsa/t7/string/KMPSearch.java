package com.jenu.lbdsa.t7.string;

/**
 *
 * KMP String Search
 * -----------------
 * 
 * Knuth-Morris-Pratt Algorithm. Performs better for large string search.
 * 
 * The idea is to create a lookup table and skip the unwanted character matches happening in a bruteforce
 * approach.
 *
 * We will create a look up table, such that at each point we will get the length of longest prefix, which is
 * also a suffix. Prefix and suffix cannot be entire string length. Atmost it will be of n-1 length.
 *
 * Eg:
 *
 * A B A C A B A
 *
 * 0 0 1 0 1 2 3
 * 
 * After that we will now try to match each character of text with pattern. If a match is found, we will increment
 * the counters of both text and pattern. If match is not found, we will move the cursor of pattern to the lookup
 * value of previous element. We will move back, until match is found or j is 0. Once j reaches 0, we will increment i
 * and move on.
 * 
 * 
 * Time Complexity :
 * -----------------
 * 
 * Lookup Table : ~ O(log2P)
 * 
 * Search : ~ O(log(N+P))
 * 
 * Worst : ~ O(N)
 * 
 * 
 * @author Janardhanan V S
 *
 */
public class KMPSearch {
	
	static boolean search(String text, String pattern) {
		final char[] textArr = text.toCharArray();
		final char[] patternArr = pattern.toCharArray();
		final Tuple[] lookupTable = createLookupTable(patternArr);
		boolean found = false;
		
		int i = 0;
		int j = 0;
		
		while(i < textArr.length && j < patternArr.length) {
			if(textArr[i] == patternArr[j]) {
				i++;
				j++;
			} else {
				if(j==0) {
					i++;
				} else {
					j = lookupTable[j-1].val;
				}
			}
		}
		
		if(j == patternArr.length) {
			found = true;
		}
		
		return found;
	}
	
	static Tuple[] createLookupTable(char[] patternArr) {
		final Tuple[] lookupTable = new Tuple[patternArr.length];
		int i = 0;
		int j = 0;
		int k = 0;
		
		lookupTable[k++] = new Tuple(patternArr[i++], j);
		
		while(i < patternArr.length) {
			if(patternArr[i] == patternArr[j]) {
				lookupTable[k++] = new Tuple(patternArr[i], j+1);
				i++;
				j++;
			} else {
				if(j==0) {
					lookupTable[k++] = new Tuple(patternArr[i], j);
					i++;
				} else {
					j = lookupTable[j-1].val;
				}
			}
		}
		
		return lookupTable;
	}
	
	public static void main(String[] args) {
		String text = "ABABACDABADABACABA";
		String pattern = "ABACABA";
		boolean found = search(text, pattern);

		System.out.println("Text : " + text);
		System.out.println("Pattern : " + pattern);
		System.out.println("Found : " + found);
		
		pattern = "ABACABB";
		found = search(text, pattern);
		
		System.out.println("\nText : " + text);
		System.out.println("Pattern : " + pattern);
		System.out.println("Found : " + found);
	}
	
	static class Tuple {
		char c;
		int val;
		
		public Tuple(char c, int val) {
			this.c = c;
			this.val = val;
		}
	}
	

}
