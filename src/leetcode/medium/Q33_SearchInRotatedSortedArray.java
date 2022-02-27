package leetcode.medium;

public class Q33_SearchInRotatedSortedArray {
    class Solution {
        int[] values;
        public int search(int[] nums, int target) {
            values = nums;
            return find(0, nums.length - 1, target);
        }

        public int find(int start, int end, int target){
            if(start + 1 >= end){
                if(values[start] == target){
                    return start;
                }else if(values[end] == target){
                    return end;
                }else{
                    return -1;
                }
            }
            int mid = (start + end) / 2;
            int left = find(start, mid, target);
            if(left >= 0) return left;
            int right = find(mid + 1, end, target);
            if(right >= 0) return right;
            return -1;
        }
    }
}
