package programmers.level2;

public class Q전력망을둘로나누기 {
    class Solution {
        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;
            boolean[][] map = new boolean[n][n];
            for(int[] wire : wires){
                map[wire[0] - 1][wire[1] - 1] = true;
                map[wire[1] - 1][wire[0] - 1] = true;
            }
            for(int[] wire : wires){
                map[wire[0] - 1][wire[1] - 1] = false;
                map[wire[1] - 1][wire[0] - 1] = false;
                int a = find(wire[0] - 1, n, 0, new boolean[n], map);
                int b = find(wire[1] - 1, n, 0, new boolean[n], map);
                answer = Math.min(answer, Math.abs(a - b));
                map[wire[0] - 1][wire[1] - 1] = true;
                map[wire[1] - 1][wire[0] - 1] = true;
            }
            return answer;
        }

        public int find(int idx, int n, int count, boolean[] visited, boolean[][] map){
            visited[idx] = true;
            count += 1;
            for (int i = 0; i < n; i++) {
                if(!visited[i] && map[idx][i]){
                    count = find(i, n, count, visited, map);
                }
            }
            return count;
        }
    }
}
