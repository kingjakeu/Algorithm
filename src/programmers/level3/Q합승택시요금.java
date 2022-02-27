package programmers.level3;

public class Q합승택시요금 {
     class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int[][] fareMap = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    fareMap[i][j] = 100000 * n;
                    if(i == j) fareMap[i][j] = 0;
                }
            }

            for(int[] fare : fares){
                fareMap[fare[0] - 1][fare[1] - 1] = fare[2];
                fareMap[fare[1] - 1][fare[0] - 1] = fare[2];
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        fareMap[i][j] = Math.min(fareMap[i][j], fareMap[i][k] + fareMap[k][j]);
                    }
                }
            }

            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int sum = fareMap[s - 1][i];
                sum += fareMap[i][a - 1];
                sum += fareMap[i][b - 1];
                answer = Math.min(sum, answer);
            }
            return answer;
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int a = s.solution(6, 4, 6, 2,
//                new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
//        System.out.println(a);
//    }
}
