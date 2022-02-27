package leetcode.medium;

import java.util.Arrays;

public class Q322_CoinChange {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] cache = new int[amount + 1];
            int length = coins.length;
            Arrays.fill(cache, Integer.MAX_VALUE);
            cache[0] = 0;
            // 1 2 5
            for (int i = 1; i <= amount ; i++) {
                for (int j = 0; j < length; j++) {
                    if(i - coins[j] >= 0 && cache[i- coins[j]] != Integer.MAX_VALUE){
                        cache[i] = Math.min(cache[i], cache[i - coins[j]] + 1);
                    }
                }
            }
            return cache[amount] == Integer.MAX_VALUE ? -1 : cache[amount];
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            s.coinChange(new int[]{1, 2, 5}, 11);
        }
    }
}
