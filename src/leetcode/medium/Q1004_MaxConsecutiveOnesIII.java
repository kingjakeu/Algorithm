package leetcode.medium;

public class Q1004_MaxConsecutiveOnesIII {
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int length = nums.length;

            int start = 0;
            int end = 0;
            int count = 0;
            int answer = 0;
            while(start < length && end < length){
                if(nums[end] == 0){
                    count += 1;
                    while(count > k){
                        if(nums[start++] == 0){
                            count -= 1;
                        }
                    }
                }
                answer = Math.max(answer, end - start + 1);
                end += 1;
            }

            return answer;
        }
    }
}
