package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class Q경주로건설 {
    class Solution {
        // L R D U
        int[][] offset = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public int solution(int[][] board) {
            int n = board.length;
            int[][][] costMap = new int[n][n][4];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 4; k++) {
                        costMap[i][j][k] = Integer.MAX_VALUE;
                    }
                }
            }
            Queue<Dot> queue = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                queue.add(new Dot(0, 0, i));
                costMap[0][0][i] = 0;
            }

            while (!queue.isEmpty()){
                Dot dot = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int dx = dot.x + offset[i][0];
                    int dy = dot.y + offset[i][1];
                    if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
                        int cost = costMap[dot.y][dot.x][dot.dir] + computeCost(dot.dir, i);
                        if(costMap[dy][dx][i] > cost && board[dy][dx] == 0){
                            costMap[dy][dx][i] = cost;
                            queue.add(new Dot(dy, dx, i));
                        }
                    }
                }
            }
            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                if(costMap[n - 1][n - 1][i] < Integer.MAX_VALUE){
                    answer = Math.min(answer, costMap[n - 1][n - 1][i]);
                }
            }
            return answer;
        }

        public int computeCost(int curr, int next){
            if(curr == 0 || curr == 1){
                if(next == 0 || next == 1){
                    return 100;
                }else{
                    return 600;
                }
            }else{
                if(next == 2 || next == 3){
                    return 100;
                }else{
                    return 600;
                }
            }
        }

        class Dot {
            int x;
            int y;
            int dir;
            Dot(int y, int x, int dir){
                this.x = x;
                this.y = y;
                this.dir = dir;
            }
        }
    }

//    public static void main(String[] args) {
//
//        Solution s = new Solution();
//        int a = s.solution(new int[][]{
//                {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}
//        });
//        System.out.println(a);
//    }
}
