package programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class Q로또의최고순위와최저순위 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            Set<Integer> numSet = new HashSet<>();
            for(int w : win_nums){
                numSet.add(w);
            }

            int minMatch = 0;
            int maxMatch = 0;
            for (int l : lottos){
                if(l == 0){
                    maxMatch += 1;
                }else{
                    if(numSet.contains(l)){
                        minMatch += 1;
                        maxMatch += 1;
                    }
                }
            }

            int[] answer = {Math.min(7 - maxMatch, 6), Math.min(7 - minMatch, 6)};
            return answer;
        }
    }
}
