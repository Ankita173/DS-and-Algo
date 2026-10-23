package org.example.neetcode.dp1d;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        Arrays.fill(memo, amount+1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }
        return memo[amount] > amount ? -1 : memo[amount];
    }
}
