package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q게임맵최단거리 {
    class Solution {
        int[][] offset = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        public int solution(int[][] maps) {
            int height = maps.length;
            int width = maps[0].length;
            int[][] cache = new int[height][width];

            Queue<Dot> que = new LinkedList<>();
            que.add(new Dot(0,0));
            cache[0][0] = 1;
            while(!que.isEmpty()){
               Dot dot = que.poll();
                for (int i = 0; i < 4; i++) {
                    int dx = dot.x + offset[i][0];
                    int dy = dot.y + offset[i][1];
                    if(dx >= 0 && dx < width && dy >= 0 && dy < height){
                        if(maps[dy][dx] == 1 && cache[dy][dx] == 0){
                            cache[dy][dx] = cache[dot.y][dot.x] + 1;
                            que.add(new Dot(dx, dy));
                        }
                    }
                }
            }
            return cache[height - 1][width - 1] == 0 ? -1 : cache[height - 1][width - 1];
        }
    }
    class Dot{
        int x;
        int y;
        Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
