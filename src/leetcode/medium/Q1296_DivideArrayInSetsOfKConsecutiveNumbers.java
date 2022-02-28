package leetcode.medium;

import java.util.*;

/**
 * #coupang
 */
public class Q1296_DivideArrayInSetsOfKConsecutiveNumbers {
    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {
            if(k <= 1) return true;
            Map<Integer, Integer> numMap = new HashMap<>();
            List<Integer> numList = new ArrayList<>();
            for(int n : nums){
                if(!numMap.containsKey(n)){
                    numList.add(n);
                    numMap.put(n, 1);
                }else{
                    numMap.put(n, numMap.get(n) + 1);
                }
            }

            Collections.sort(numList);
            List<LinkedList<Integer>> setList = new LinkedList<>();
            for(int n : numList){
                int count = numMap.get(n);
                int idx = 0;
                int size = setList.size();
                for (int i = 0; i < size && count > 0; i++) {
                    if(n - setList.get(idx).getLast() == 1){
                        int sum = setList.get(idx).size() + 1;
                        if(sum == k){
                            setList.remove(idx);
                            idx -= 1;
                        }else{
                            setList.get(idx).add(n);
                        }
                        idx += 1;
                        count -= 1;
                    }else{
                        return false;
                    }
                }
                for (int i = 0; i < count; i++) {
                    setList.add(new LinkedList<>(List.of(n)));
                }
            }
            return setList.isEmpty();
        }
    }
}
