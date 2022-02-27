package leetcode.easy;

public class Q70_ClimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            int[] cache = new int[n + 1];
            cache[0] = 1;
            cache[1] = 1;
            for (int i = 2; i < n; i++) {
                cache[i] = cache[i - 2] + cache[i - 1];
            }
            return cache[n];
        }
    }
}
