package leetcode.medium;

public class Q713_SubarrayProductLessThanK {
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if(k <= 1) return 0;
            int product = 1;
            int left = 0;
            int answer = 0;
            for (int i = 0; i < nums.length; i++) {
                product *= nums[i];
                while(product >= k){
                    product /= nums[left++];
                }
                answer += i - left + 1;
            }
            return answer;
        }
    }
}
