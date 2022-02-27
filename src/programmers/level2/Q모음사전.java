package programmers.level2;

public class Q모음사전 {
    static class Solution {
        char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
        int count;
        public int solution(String word) {
            count = -1;
            return find(word, new StringBuilder());
        }

        public int find(String target, StringBuilder visited){
            count += 1;
            if(visited.toString().equals(target)){
                return count;
            }
            int lastIdx = visited.length();
            if(lastIdx < 5){
                for(char alpha : alphabet){
                    int idx = find(target, visited.append(alpha));
                    if(idx > 0) return idx;
                    visited.deleteCharAt(lastIdx);
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("AAAE"));
    }
}
