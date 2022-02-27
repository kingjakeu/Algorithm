package programmers.level3;

public class Q기지국설치 {
    class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int left = 1;
            int right = 0;
            int div = (w * 2) + 1;
            for (int i = 0; i < stations.length; i++) {
                right = Math.max(stations[i] - w, left);
                int length = right - left;
                answer += length / div;
                answer += length % div > 0 ? 1 : 0;
                left = Math.min(stations[i] + w + 1, n + 1);
            }
            int length = n + 1 - left;
            answer += length / div;
            answer += length % div > 0 ? 1 : 0;
            return answer;
        }
    }
}
