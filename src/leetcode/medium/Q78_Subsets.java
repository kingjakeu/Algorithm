package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q78_Subsets {
    class Solution {
        int length;
        List<List<Integer>> answer;
        public List<List<Integer>> subsets(int[] nums) {
            length = nums.length;
            answer = new ArrayList<>();

            LinkedList<Integer> unvisited = new LinkedList<>();
            for(int n : nums){
                unvisited.add(n);
            }

            find(new LinkedList<>(), unvisited);
            return answer;
        }

        public void find(LinkedList<Integer> currSet, LinkedList<Integer> unvisited){
            answer.add(List.copyOf(currSet));

            int size = unvisited.size();
            List<Integer> tmpList = new ArrayList<>();
            for(int i = 0; i < size; i++){
                currSet.add(unvisited.removeFirst());
                find(currSet, unvisited);
                tmpList.add(currSet.removeLast());
            }
            unvisited.addAll(tmpList);
        }
    }
}
