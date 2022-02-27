package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q15_3Sum {
    static class Solution {
        List<List<Integer>> answer;
        public List<List<Integer>> threeSum(int[] nums) {
            answer = new ArrayList<>();
            Arrays.sort(nums);

            int left = 0;
            int right = nums.length - 1;

            while(left < right){
                if(nums[left] > 0) break;
                find(left, right, nums);
                int tmpLeft = left;
                while (left < right && nums[left] == nums[tmpLeft]){
                    left += 1;
                }
            }
            return answer;
        }
        public void find(int left, int right, int[] nums){
            int mid = left + 1;
            while (mid < right){
                int val = nums[left] + nums[mid] + nums[right];
                if(val ==  0){
                    answer.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    int tmpMid = mid;
                    while (mid < right && nums[mid] == nums[tmpMid]){
                        mid += 1;
                    }
                }else if(val < 0){
                    mid += 1;
                }else {
                    right -= 1;
                }
            }
        }


        public static void main(String[] args) {
            Solution s = new Solution();
            List<List<Integer>> ans = s.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
            for(List<Integer> a : ans){
                for(int i : a){
                    System.out.print(i +" ");
                }
                System.out.println();
            }
        }
    }
}
