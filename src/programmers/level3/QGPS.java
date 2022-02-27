package programmers.level3;

public class QGPS {
    static class Solution {
        public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
            boolean[][] map = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                map[i][i] = true;
            }
            for(int[] edge : edge_list){
                map[edge[0] - 1][edge[1] - 1] = true;
                map[edge[1] - 1][edge[0] - 1] = true;
            }

            int[][] cache = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    cache[i][j] = 10001;
                }
            }

            int start = gps_log[0] - 1;
            cache[0][start] = 0;

            for (int i = 0; i < k - 1; i++) {
                for (int j = 0; j < n; j++) {
                    if(cache[i][j] < 10001){
                        for (int l = 0; l < n; l++) {
                            if(map[j][l]){
                                int val = l == gps_log[i + 1] - 1 ? 0 : 1;
                                val += cache[i][j];
                                cache[i + 1][l] = Math.min(cache[i + 1][l], val);
                            }
                        }
                    }
                }
            }
            return cache[k - 1][gps_log[k - 1] - 1] < 10001 ? cache[k - 1][gps_log[k - 1] - 1] : -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = s.solution(7, 10,
                new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}},
                6, new int[]{1, 2, 3, 3, 6, 7});
        System.out.println(a);
    }
}
