package programmers.level2;

public class Q방문길이 {
    class Solution {
        int[][] offset = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        public int solution(String dirs) {
            int answer = 0;
            boolean[][][] visited = new boolean[11][11][4];
            int x = 5;
            int y = 5;
            for (char c : dirs.toCharArray()){
                int d = convertDir(c);
                int dx = x + offset[d][0];
                int dy = y + offset[d][1];
                if(dx >= 0 && dx <= 10 && dy >= 0 && dy <= 10){
                    if(!visited[y][x][d]){
                        answer += 1;
                    }
                    visited[y][x][d] = true;
                    visited[dy][dx][inverseDir(d)] = true;
                    x = dx;
                    y = dy;
                }
            }
            return answer;
        }
        public int convertDir(char c){
            if(c == 'U'){
                return 0;
            }else if(c == 'D'){
                return 1;
            }else if(c == 'L'){
                return 2;
            }
            return 3;
        }
        public int inverseDir(int i){
            if(i == 0) return 1;
            else if(i == 1) return 0;
            else if(i == 2) return 3;
            else return 2;
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.solution("LULLLLLLU");
//    }
}
