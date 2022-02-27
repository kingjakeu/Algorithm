package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Q217_ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> numSet = new HashSet<>();
            for(int n : nums){
                if(numSet.contains(n)) return true;
                numSet.add(n);
            }
            return false;
        }
    }
}
