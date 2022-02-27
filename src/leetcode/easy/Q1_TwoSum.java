package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1_TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numMap = new HashMap<>();
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                int diff = target - nums[i];
                if(numMap.containsKey(diff)){
                    return new int[]{numMap.get(diff), i};
                }
                numMap.put(nums[i], i);
            }
            return new int[]{0, 1};
        }
    }
}
