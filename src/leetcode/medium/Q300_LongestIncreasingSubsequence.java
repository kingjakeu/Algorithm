package leetcode.medium;

import java.util.Arrays;

public class Q300_LongestIncreasingSubsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int length = nums.length;
            int[] cache = new int[length];
            Arrays.fill(cache, 1);
            int maxVal = cache[0];
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]){
                        cache[i] = Math.max(cache[i], cache[j] + 1);
                    }
                }
                maxVal = Math.max(maxVal, cache[i]);
            }
            return maxVal;
        }
    }
}
