package leetcode.medium;

public class Q153_FindMinimumInRotatedSortedArray {
    static class Solution {
        public int findMin(int[] nums) {
            return find(0, nums.length - 1, nums);
        }

        // 2 3 4 5 1
        public int find(int start, int end, int[] nums){
            if(start + 1 >= end){
                return Math.min(nums[start], nums[end]);
            }

            int mid = (start + end) / 2;
            return Math.min(find(start, mid, nums), find(mid + 1, end, nums));
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            s.findMin(new int[]{3, 4, 5, 1, 2});
        }
    }
}
