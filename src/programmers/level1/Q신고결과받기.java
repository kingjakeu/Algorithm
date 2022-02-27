package programmers.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q신고결과받기 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            Map<String, Set<String>> repoMap = new HashMap<>();
            Map<String, Integer> countMap = new HashMap<>();
            for(String id : id_list){
                repoMap.put(id, new HashSet<>());
                countMap.put(id, 0);
            }

            for(String repo : report){
                String[] repoSplit = repo.split(" ");
                repoMap.get(repoSplit[1]).add(repoSplit[0]);
            }

            for(String id : id_list){
                if(repoMap.get(id).size() >= k){
                    for(String reporter : repoMap.get(id)) {
                        countMap.put(reporter, countMap.get(reporter) + 1);
                    }
                }
            }

            int[] answer = new int[id_list.length];
            for (int i = 0; i < id_list.length; i++) {
                answer[i] = countMap.get(id_list[i]);
            }
            return answer;
        }
    }
}
