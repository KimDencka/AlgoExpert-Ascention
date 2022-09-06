package dencka.kim.easy.collection;

import java.util.Arrays;

class NonConstructibleChange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 1, 1, 2, 3, 22};
        System.out.println(nonConstructibleChange(nums));
    }

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int cnt = 0;
        for (int coin : coins) {
            if (coin > cnt + 1) break;
            cnt += coin;
        }
        return cnt + 1;
    }
}
