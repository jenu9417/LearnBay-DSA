package com.jenu.lbdsa.t9.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * +---------------------+
 * | Coin Change Problem |
 * +---------------------+
 * 
 * Given an array of coins, with infinite supply of each, find the combination with least number of coins
 * for a given value
 * 
 * Eg:
 * N = 10
 * Coins : [ 2, 5, 3, 6 ]
 * 
 * Here, the possible solutions are {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}
 * Of them {5,5} contains the least number of coins
 * 
 * 
 * Time  : O(max(coins) * number of coins)
 * Space : O(max(coins) * number of coins)
 * 
 * 
 * @author Janardhanan V S
 *
 */
public class CoinChangeProblem {
	
	public static Comparator<Tuple> tupleComparator =  new Comparator<Tuple>() {
		@Override
		public int compare(Tuple o1, Tuple o2) {
			if(o1.value == o2.value) {
				return Integer.compare(o2.coins.size(), o1.coins.size());
			}
			return Integer.compare(o1.value, o2.value);
		}
	};
	
	static Tuple changeCoins(int target, int[] coins) {
		Tuple[][] tupleTable = new Tuple[coins.length][target+1];
		Tuple change = new Tuple(0, Collections.emptyList());
		for(int i=0; i<coins.length; i++) {
			for(int j=1; j<target+1; j++) {
				if(i==0) {
					if(j<coins[i]) {
						tupleTable[i][j] = new Tuple(0, Collections.emptyList());;
					} else {
						final List<Integer> coinList = new ArrayList<>();
						coinList.add(coins[i]);
						final Tuple tuple = new Tuple(coins[i], coinList);
						tuple.merge(tupleTable[i][j-coins[i]]);
						tupleTable[i][j] = tuple;
					}
				} else {
					if(j<coins[i]) {
						tupleTable[i][j] = tupleTable[i-1][j];
					} else {
						final List<Integer> coinList = new ArrayList<>();
						coinList.add(coins[i]);
						final Tuple tuple = new Tuple(coins[i], coinList);
						tuple.merge(tupleTable[i][j-coins[i]]);
						tupleTable[i][j] = tuple;
					}
				}
				change = (tupleComparator.compare(change, tupleTable[i][j]) == -1) ? tupleTable[i][j] : change;
			}
		}
		return change;
	}
	
	
	static class Tuple {
		int value;
		List<Integer> coins;
		
		Tuple(int value, List<Integer> coins) {
			this.value = value;
			this.coins = coins;
		}
		
		void merge(Tuple tuple) {
			if(tuple == null || tuple.coins.size() == 0) {
				return;
			}
			this.value += tuple.value;
			this.coins.addAll(tuple.coins);
		}
	}
	
	public static void main(String[] args) {
		int[] coins = { 2, 5, 3, 6 };
		int target = 10;
		Tuple change = changeCoins(target, coins);
		System.out.printf("Value %d  ::  Coins : %s", target, Arrays.toString(change.coins.toArray()));
	}
}
