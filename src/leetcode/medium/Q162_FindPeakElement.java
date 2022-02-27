package leetcode.medium;

public class Q162_FindPeakElement {
    class Solution {
        int maxVal;
        public int findPeakElement(int[] nums) {
            maxVal = 0;
            int left = 0;
            int right = nums.length - 1;
            find(left, right, nums);
            return maxVal;
        }

        public void find(int left, int right, int[] nums){
            if (left == right){
                if (nums[maxVal] < nums[left]){
                    maxVal = left;
                }
            }

            if(left < right){
                int mid = (left + right) / 2;
                if(nums[mid] > nums[mid + 1]){
                    find(left, mid, nums);
                }else{
                    find(mid + 1, right, nums);
                }
            }
        }
    }
}
