package programmers.level1;

import java.util.*;

public class Q두개뽑아서더하기 {
    class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> sumSet = new HashSet<>();
            int length = numbers.length;
            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    sumSet.add(numbers[i] + numbers[j]);
                }
            }
            List<Integer> sumList = new ArrayList<>(sumSet);
            Collections.sort(sumList);

            int[] answer = new int[sumList.size()];
            int idx = 0;
            for(int s : sumList){
                answer[idx++] = s;
            }
            return answer;
        }
    }
}
