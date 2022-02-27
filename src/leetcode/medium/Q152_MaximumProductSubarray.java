package leetcode.medium;

public class Q152_MaximumProductSubarray {
    class Solution {
        public int maxProduct(int[] nums) {
            int length = nums.length;
            int[] minCache = new int[length];
            int[] maxCache = new int[length];
            minCache[0] = nums[0];
            maxCache[0] = nums[0];

            int answer = nums[0];
            for (int i = 1; i < length; i++) {
                int min = minCache[i - 1] * nums[i];
                int max = maxCache[i - 1] * nums[i];
                minCache[i] = Math.min(nums[i], Math.min(max, min));
                maxCache[i] = Math.max(nums[i], Math.max(max, min));
                answer = Math.max(answer, minCache[i]);
                answer = Math.max(answer, maxCache[i]);
            }
            return answer;
        }
    }
}
