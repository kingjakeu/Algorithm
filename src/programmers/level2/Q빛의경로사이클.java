package programmers.level2;

import java.util.*;

public class Q빛의경로사이클 {
    class Solution {
        char[][] gridMap;
        int height;
        int width;
        boolean[][][] visited;
        List<Integer> answer;
        // D, U, R, L
        int[][] offset = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public int[] solution(String[] grid) {
            answer = new ArrayList<>();
            height = grid.length;
            width = grid[0].length();
            visited = new boolean[height][width][4];
            gridMap = new char[height][width];

            Queue<Dot> que = new LinkedList<>();

            for (int i = 0; i < height; i++) {
                char[] tmp = grid[i].toCharArray();
                for (int j = 0; j < width; j++) {
                    gridMap[i][j] = tmp[j];
                    for (int k = 0; k < 4 ; k++) {
                        que.add(new Dot(j, i, k));
                    }
                }
            }
            while (!que.isEmpty()){
                Dot dot = que.poll();
                if(!visited[dot.y][dot.x][dot.off]){
                    findCycle(dot.x, dot.y, dot.off);
                }
            }

            Collections.sort(answer);
            int[] answerArr = new int[answer.size()];
            for (int i = 0; i < answerArr.length; i++) {
                answerArr[i] = answer.get(i);
            }
            return answerArr;
        }

        public void findCycle(int x, int y, int off){
            Queue<Dot> que = new LinkedList<>();
            que.add(new Dot(x, y, off));
            int count = 0;
            while(!que.isEmpty()){
                Dot dot = que.poll();
                visited[dot.y][dot.x][dot.off] = true;
                count += 1;

                int dx = dot.x + offset[dot.off][0];
                if(dx < 0) dx = width -1;
                else if(dx >= width) dx = 0;

                int dy = dot.y + offset[dot.off][1];
                if(dy < 0) dy = height - 1;
                else if(dy >= height) dy = 0;

                int doff = dot.off;
                // D, U, R, L
                if(gridMap[dy][dx] == 'L'){
                    if (dot.off == 0) doff = 2;
                    else if(dot.off == 1) doff = 3;
                    else if(dot.off == 2) doff = 1;
                    else doff = 0;
                }else if(gridMap[dy][dx] == 'R'){
                    if (dot.off == 0) doff = 3;
                    else if(dot.off == 1) doff = 2;
                    else if(dot.off == 2) doff = 0;
                    else doff = 1;
                }

                if(dy == y && dx == x && doff == off){
                    answer.add(count);
                    return;
                }else{
                    que.add(new Dot(dx, dy, doff));
                }
            }
        }
    }
    class Dot{
        int x;
        int y;
        int off;
        Dot(int x, int y, int off){
            this.x = x;
            this.y = y;
            this.off = off;
        }
        public String toString(){
            return x + " " + y + " " + off;
        }
    }
}
