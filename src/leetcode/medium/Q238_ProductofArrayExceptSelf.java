package leetcode.medium;

public class Q238_ProductofArrayExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int length = nums.length;

            int[] leftArr = new int[length];
            leftArr[0] = 1;
            for (int i = 1; i < length; i++) {
                leftArr[i] = leftArr[i - 1] * nums[i - 1];
            }

            int rightNum = 1;
            for (int i = length - 2; i >= 0; i--) {
                rightNum = rightNum * nums[i + 1];
                leftArr[i] = leftArr[i] * rightNum;
            }

            return leftArr;
        }
    }
}
