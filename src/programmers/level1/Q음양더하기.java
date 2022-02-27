package programmers.level1;

public class Q음양더하기 {
    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for (int i = 0; i < absolutes.length; i++) {
                int n = absolutes[i];
                n = signs[i] ? n : n * -1;
                answer += n;
            }
            return answer;
        }
    }
}
