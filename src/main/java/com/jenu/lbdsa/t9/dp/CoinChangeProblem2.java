package com.jenu.lbdsa.t9.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * +---------------------+
 * | Coin Change Problem |
 * +---------------------+
 * 
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} 
 * valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 *
 * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. 
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
 * So the output should be 5.
 * 
 * 
 * @author Janardhanan V S
 *
 */
public class CoinChangeProblem2 {
	
	static List<List<Integer>> solutionList = new ArrayList<>();
	
	static void changeCoins(int target, int lastCoin, List<Integer> availableCoins, List<Integer> currentCoins) {
		if(target == 0) {
			solutionList.add(new ArrayList<>(currentCoins));
			return;
		}
		if(target < 0) {
			return;
		}
		for(Integer coin : availableCoins) {
			if(coin < lastCoin) {
				continue;
			}
			currentCoins.add(coin);
			changeCoins(target-coin, coin, availableCoins, currentCoins);
			currentCoins.remove(currentCoins.size()-1);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> coins = Arrays.asList(2, 5, 3, 6);
		int target = 10;
		changeCoins(target, -1, coins, new ArrayList<>());
		System.out.println("Solutions : \n");
		solutionList.stream().forEach(x -> System.out.println(Arrays.toString(x.toArray())));
	}
}
