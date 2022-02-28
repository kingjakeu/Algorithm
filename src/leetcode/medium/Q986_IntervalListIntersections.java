package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q986_IntervalListIntersections {
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            int fIdx = 0;
            int fLength = firstList.length;

            int sIdx = 0;
            int sLength = secondList.length;

            List<int[]> numList = new ArrayList<>();
            while (fIdx < fLength && sIdx < sLength){
                if((firstList[fIdx][0] <= secondList[sIdx][0] && firstList[fIdx][1] >= secondList[sIdx][0])
                || secondList[sIdx][0] <= firstList[fIdx][0] && secondList[sIdx][1] >= firstList[fIdx][0]){
                    numList.add(new int[]{
                            Math.max(firstList[fIdx][0], secondList[sIdx][0]),
                            Math.min(firstList[fIdx][1], secondList[sIdx][1])
                    });
                }
                if(firstList[fIdx][1] < secondList[sIdx][1]){
                    fIdx += 1;
                }else if(secondList[sIdx][1] < firstList[fIdx][1]){
                    sIdx += 1;
                }else{
                    fIdx += 1;
                    sIdx += 1;
                }
            }
            int[][] answer = new int[numList.size()][2];
            int i = 0;
            for(int[] arr : numList){
                answer[i++] = arr;
            }
            return answer;
        }
    }
}
