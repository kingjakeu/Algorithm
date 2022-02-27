package programmers.level1;

import java.util.*;

public class Q단체사진찍기 {
    class Solution {
        static Map<Character, List<Info>> restrictMap;
        static int[] indexArr;
        static int answer;
        public int solution(int n, String[] data) {
            List<Character> idList = new ArrayList<>(Arrays.asList('A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'));
            restrictMap = new HashMap<>();
            indexArr = new int[999];
            answer = 0;

            for(char id : idList){
                indexArr[id] = -1;
                restrictMap.put(id, new ArrayList<>());
            }

            for(String d : data){
                int distance = Integer.parseInt(d.substring(4));
                restrictMap.get(d.charAt(0)).add(new Info(d.charAt(2), distance, d.charAt(3)));
            }
            find(new ArrayList<>(), idList);
            return answer;
        }

        public void find(List<Character> visited, List<Character> unvisited){

            if(unvisited.isEmpty()){
                for (int i = 0; i < visited.size(); i++) {
                    List<Info> infoList = restrictMap.get(visited.get(i));
                    for(Info info : infoList){
                        int targetIdx = indexArr[info.id];
                        int diff = Math.abs(i - targetIdx);
                        if(info.sign == '='){
                            if(diff != info.d + 1) return;
                        }else if(info.sign == '<'){
                            if(diff > info.d) return;
                        }else if(info.sign == '>'){
                            if(diff <= info.d + 1) return;
                        }
                    }
                }
                answer += 1;
            }

            int length = unvisited.size();
            int lastIdx = visited.size();
            for (int i = 0; i < length; i++) {
                char c = unvisited.remove(0);
                visited.add(c);
                indexArr[c] = lastIdx;
                find(visited, unvisited);
                indexArr[c] = -1;
                unvisited.add(visited.remove(lastIdx));
            }
        }
    }
    class Info {
        char id;
        int d;
        char sign;
        Info(char id, int d, char sign){
            this.id = id;
            this.d = d;
            this.sign = sign;
        }
    }
}
