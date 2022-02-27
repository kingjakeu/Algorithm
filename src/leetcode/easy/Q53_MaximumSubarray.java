package leetcode.easy;

public class Q53_MaximumSubarray {
    class Solution {
        public int maxSubArray(int[] nums) {
            int length = nums.length;
            if(length == 1) return nums[0];
            int[] cache = new int[length];
            cache[0] = nums[0];

            int answer = cache[0];
            for (int i = 1; i < length; i++) {
                cache[i] = Math.max(nums[i], cache[i - 1] + nums[i]);
                answer = Math.max(answer, cache[i]);
            }
            return answer;
        }
    }
}
