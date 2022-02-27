package programmers.level2;

public class Q행렬테두리회전하기 {
    class Solution {
        int[][] map;
        int[][] offset = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        public int[] solution(int rows, int columns, int[][] queries) {
            map = new int[rows][columns];
            int count = 1;
            for (int i = 0; i < rows ; i++) {
                for (int j = 0; j < columns; j++) {
                    map[i][j] = count++;
                }
            }
            int[] answer = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                answer[i] = find(queries[i]);
            }
            return answer;
        }
        public int find(int[] query){
            int startY = query[0] - 1;
            int startX = query[1] - 1;
            int endY = query[2] - 1;
            int endX = query[3] - 1;

            int minNum = map[startY][startX];
            int x = startX;
            int y = startY;
            int off = 0;
            int lastIn = map[startY][startX];
            while(off < 4){
                minNum = Math.min(minNum, map[y][x]);
                int dx = x + offset[off][0];
                int dy = y + offset[off][1];
                if(dx < startX || dx > endX || dy < startY || dy > endY){
                    off += 1;
                }else{
                    x = dx;
                    y = dy;
                    int tmp = map[y][x];
                    map[y][x] = lastIn;
                    lastIn = tmp;
                }
            }
            return minNum;
        }
    }
}
