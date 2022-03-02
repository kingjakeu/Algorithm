package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Q163_MissingRanges {
    class Solution {
        public List<String> findMissingRanges(int[] nums, int lower, int upper) {
            List<String> answer = new ArrayList<>();
            int length = nums.length;

            int start = lower;
            for (int i = 0; i < length; i++){
                int end = nums[i] - 1;
                if(start == end){
                    answer.add(String.valueOf(start));
                }else if(start < end){
                    answer.add(start + "->" + end);
                }
                start = nums[i] + 1;
            }
            int end = upper;
            if(start == end){
                answer.add(String.valueOf(start));
            }else if(start < end){
                answer.add(start + "->" + end);
            }

            return answer;
        }
    }
}
