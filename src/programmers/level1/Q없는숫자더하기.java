package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class Q없는숫자더하기 {
    class Solution {
        public int solution(int[] numbers) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                countMap.put(i, 0);
            }

            for(int n : numbers){
                countMap.put(n, countMap.get(n) +1);
            }

            int answer = 0;
            for (int i = 0; i < 10; i++) {
                if(countMap.get(i) == 0){
                    answer += i;
                }
            }
            return answer;
        }
    }
}
