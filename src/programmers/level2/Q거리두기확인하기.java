package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Q거리두기확인하기 {
    class Solution {
        int[][] offset = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
        public int[] solution(String[][] places) {
            int[] answer = new int[5];
            int idx = 0;
            for(String[] place : places){
                char[][] map = new char[5][5];
                for (int i = 0; i < 5; i++) {
                    char[] placeChar = place[i].toCharArray();
                    for (int j = 0; j < 5; j++) {
                        map[i][j] = placeChar[j];
                    }
                }
                answer[idx++] = findIrregular(map);
            }
            return answer;
        }

        public int findIrregular(char[][] place){
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if(place[i][j] == 'P'){
                        boolean[][] visited = new boolean[5][5];
                        Queue<Dot> que = new LinkedList<>();
                        que.add(new Dot(j, i));
                        while(!que.isEmpty()){
                            Dot dot = que.poll();
                            visited[dot.y][dot.x] = true;
                            if(place[dot.y][dot.x] == 'P'){
                                int m =  Math.abs(j - dot.x) + Math.abs(i - dot.y);
                                if(m == 1){
                                    return 0;
                                }else if(m == 2){
                                    if(Math.abs(j - dot.x) == 1 || Math.abs(i - dot.y) == 1){
                                        if(place[dot.y][j] != 'X' || place[i][dot.x] != 'X'){
                                            return 0;
                                        }
                                    }else{
                                        if(Math.abs(j - dot.x) > 0){
                                            if((dot.x > j && place[i][j+1] != 'X')
                                                || (dot.x < j && place[i][j-1] != 'X')){
                                                return 0;
                                            }
                                        }else{
                                            if((dot.y > i && place[i+1][j] != 'X')
                                                    || (dot.y < i && place[i-1][j] != 'X')){
                                                return 0;
                                            }
                                        }
                                    }
                                }
                            }

                            for(int[] off : offset){
                                int dx = dot.x + off[0];
                                int dy = dot.y + off[1];
                                if(dx >= 0 && dx < 5 && dy >= 0 && dy < 5){
                                    if(!visited[dy][dx] && (Math.abs(j - dx) + Math.abs(i - dy) <= 2)){
                                        que.add(new Dot(dx, dy));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return 1;
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
