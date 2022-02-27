package leetcode.medium;

import java.util.*;

public class Q34_FindFirstAndLastPositionOfElementInSortedArray {
    class Solution {
        List<Integer> numList;
        public int[] searchRange(int[] nums, int target) {
            int length = nums.length;
            numList = new ArrayList<>();

            find(0, length - 1, target, nums);
            int size = numList.size();
            if(size == 0){
                return new int[]{-1, -1};
            }else if(size == 1){
                return new int[]{numList.get(0), numList.get(0)};
            }
            return new int[]{numList.get(0), numList.get(size - 1)};
        }

        public void find(int left, int right, int target, int[] nums){
            if(left == right){
                if(nums[left] == target){
                    numList.add(left);
                }
                return;
            }else if(left + 1 == right){
                if(nums[left] == target){
                    numList.add(left);
                }
                if(nums[right] == target){
                    numList.add(right);
                }
                return;
            }

            if(left < right){
                int mid = (left + right) / 2;
                if(nums[mid] >= target){
                    find(left, mid, target, nums);
                }
                if(nums[mid + 1] <= target){
                    find(mid + 1, right, target, nums);
                }
            }
        }
    }
}
