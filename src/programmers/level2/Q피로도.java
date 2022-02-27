package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Q피로도 {
    class Solution {
        int answer;
        public int solution(int k, int[][] dungeons) {
            answer = 0;

            List<Integer> unvisited = new ArrayList<>();
            for (int i = 0; i < dungeons.length; i++) {
                unvisited.add(i);
            }
            find(new ArrayList<>(), unvisited, k, dungeons);
            return answer;
        }

        public void find(List<Integer> visited, List<Integer> unvisited, int k, int[][] dungeons){
            int point = k;
            for(int v : visited){
                if(point < dungeons[v][0]){
                    return;
                }else{
                    point -= dungeons[v][1];
                }
            }
            answer = Math.max(answer, visited.size());

            int lastIdx = visited.size();
            for (int i = 0; i < unvisited.size(); i++) {
                visited.add(unvisited.remove(0));
                find(visited, unvisited, k, dungeons);
                unvisited.add(visited.remove(lastIdx));
            }
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[][] d = {{80,20},{50,40},{30,10}};
//        System.out.println(s.solution(80, d));
//    }
}
