package programmers.level2;

import java.util.*;

public class Q후보키 {
    class Solution {
        int height;
        int width;
        String[][] map;
        List<Set<Integer>> canList;
        public int solution(String[][] relation) {
            height = relation.length;
            width = relation[0].length;
            map = relation;

            List<Integer> possible = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                possible.add(j);
            }

            canList = new ArrayList<>();
            int answer = 0;
            for (int i = 1; i <= width; i++) {
                answer += comb(0, i, new ArrayList<>(), possible);
            }
            return answer;
        }

        public int comb(int idx, int r, List<Integer> visited, List<Integer> unvisited){
            if(visited.size() == r){
                for(Set<Integer> can : canList){
                    if(visited.containsAll(can)) return 0;
                }
                Set<String> keySet = new HashSet<>();
                for (int i = 0; i < height; i++) {
                    StringBuilder sb = new StringBuilder();
                    for(int v : visited){
                        sb.append(map[i][v]).append(" ");
                    }
                    keySet.add(sb.toString());
                }
                if(keySet.size() == height){
                    canList.add(new HashSet<>(visited));
                    return 1;
                }
                return 0;
            }
            int count = 0;
            int lastIdx = visited.size();
            for (int i = idx; i < unvisited.size(); i++) {
                visited.add(unvisited.get(i));
                count += comb(i + 1, r, visited, unvisited);
                visited.remove(lastIdx);
            }
            return count;
        }
    }
}
