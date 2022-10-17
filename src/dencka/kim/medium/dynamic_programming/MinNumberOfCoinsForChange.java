package dencka.kim.medium.dynamic_programming;

import java.util.Arrays;

class MinNumberOfCoinsForChange {
    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(20, new int[]{1, 5, 10}));
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] coins = new int[n + 1];
        Arrays.fill(coins, Integer.MAX_VALUE);
        coins[0] = 0;
        for (int num : denoms) {
            for (int i = 1; i < coins.length; i++) {
                if (i >= num) {
                    if (coins[i - num] < Integer.MAX_VALUE) {
                        coins[i] = Math.min(coins[i], coins[i - num] + 1);
                    }
                }
            }
        }
        return coins[n] != Integer.MAX_VALUE ? coins[n] : -1;
    }
}
