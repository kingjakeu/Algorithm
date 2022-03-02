package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Q1254_NumberOfClosedIslands {
    class Solution {
        int[][] offset = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited;
        int h;
        int w;

        public int closedIsland(int[][] grid) {
            h = grid.length;
            w = grid[0].length;

            visited = new boolean[h][w];

            int answer = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(grid[i][j] == 0 && !visited[i][j]){
                        if(find(j, i, grid)){
                            answer += 1;
                        }
                    }
                }
            }
            return answer;
        }

        public boolean find(int x, int y, int[][] grid){
            boolean answer = true;
            visited[y][x] = true;
            for (int i = 0; i < 4; i++) {
                int dx = x + offset[i][0];
                int dy = y + offset[i][1];
                if(dx < 0 || dx >= w || dy < 0 || dy >= h){
                    answer = false;
                }else if(!visited[dy][dx] && grid[dy][dx] == 0){
                    if(!find(dx, dy, grid)){
                        answer = false;
                    }
                }
            }
            return answer;
        }
    }
}
