package leetcode.medium;

public class Q209_MinimumSizeSubarraySum {
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int minLength = 100001;
            int left = 0;
            int right = 0;
            int length = nums.length;
            int sum = 0;
            while (right < length){
                sum += nums[right];
                while (sum >= target){
                    minLength = Math.min(minLength, right - left + 1);
                    sum -= nums[left++];
                }
                right += 1;
            }
            return minLength < 100001 ? minLength : 0;
        }
    }
}
