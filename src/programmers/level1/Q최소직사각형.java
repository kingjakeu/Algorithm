package programmers.level1;

public class Q최소직사각형 {
    class Solution {
        public int solution(int[][] sizes) {
            int min = Math.min(sizes[0][0], sizes[0][1]);
            int max = Math.max(sizes[0][0], sizes[0][1]);
            int length = sizes.length;

            for (int i = 1; i < length; i++) {
                min = Math.max(min, Math.min(sizes[i][0], sizes[i][1]));
                max = Math.max(max, Math.max(sizes[i][0], sizes[i][1]));
            }
            return min * max;
        }
    }
}
