package programmers.level2;

public class Q프렌즈4블록 {
    class Solution {
        int[][] offset = {{0, 1}, {1, 0}, {1, 1}, {0, 0}};
        char[][] map;
        int answer;
        public int solution(int m, int n, String[] board) {
            answer = 0;
            map = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = board[i].charAt(j);
                }
            }
            int prev = -1;
            while (prev != answer){
                prev = answer;
                boolean[][] visited = new boolean[m][n];
                boolean[][] removed = new boolean[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if(map[i][j] >= 'A' && map[i][j] <= 'Z' && !visited[i][j]){
                            removeSame(j, i, n, m, visited, removed);
                        }else{
                            visited[i][j] = true;
                        }
                    }
                }

                char[][] newMap = new char[m][n];
                for (int i = 0; i < n; i++) {
                    int idx = m - 1;
                    for (int j = m - 1; j >= 0; j--) {
                        if(!removed[j][i]) {
                            newMap[idx--][i] = map[j][i];
                        }else{
                            answer += 1;
                        }
                    }
                }
                map = newMap;
            }
            return answer;
        }
        public void removeSame(int x, int y, int n, int m, boolean[][] visited, boolean[][] removed){
            visited[y][x] = true;
            int count = 0;
            for (int k = 0; k < 3; k++) {
                int dx = x + offset[k][0];
                int dy = y + offset[k][1];
                if(dx >= 0 && dx < n && dy >= 0 && dy < m){
                    if(map[dy][dx] == map[y][x]){
                        count += 1;
                    }
                }
            }
            if(count == 3){
                for (int k = 0; k < 4; k++) {
                    int dx = x + offset[k][0];
                    int dy = y + offset[k][1];
                    if(!visited[dy][dx]){
                        removeSame(dx, dy, n, m, visited, removed);
                    }
                    removed[dy][dx] = true;
                }
            }
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int ans = s.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
//        System.out.println(ans);
//    }
}
