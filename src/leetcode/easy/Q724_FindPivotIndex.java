package leetcode.easy;

public class Q724_FindPivotIndex {
    class Solution {
        public int pivotIndex(int[] nums) {
            int length = nums.length;
            int[] sums = new int[length];

            sums[length - 1] = 0;
            for (int i = length - 2; i >= 0; i--){
                sums[i] = sums[i + 1] + nums[i + 1];
            }

            int sum = 0;
            for (int i = 0; i < length; i++){
                if(sum == sums[i]) return i;
                sum += nums[i];
            }
            return -1;
        }
    }
}
