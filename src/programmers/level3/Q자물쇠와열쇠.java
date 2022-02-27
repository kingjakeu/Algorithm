package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Q자물쇠와열쇠 {
    class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            int lockNum = 0;
            int n = lock.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(lock[i][j] == 0) lockNum += 1;
                }
            }

            int m = key.length;
            List<Dot> keyList = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if(key[i][j] == 1) keyList.add(new Dot(i, j));
                }
            }

            int offset = m - 1;
            for (int k = 0; k < 4; k++) {
                for (int i = -offset; i < m + offset; i++) {
                    for (int j = -offset; j < m + offset; j++) {
                        if(checkLock(i, j, keyList, lock, lockNum, n)){
                            return true;
                        }
                    }
                }
                rotate(keyList, m - 1);
            }
            return false;
        }

        public boolean checkLock(int i, int j, List<Dot> keyList, int[][] lock, int lockNum, int n){
            int count = 0;
            for(Dot dot : keyList){
                int dx = dot.x + j;
                int dy = dot.y + i;
                if (dx >= 0 && dx < n && dy >= 0 && dy < n){
                    if(lock[dy][dx] == 0){
                        count += 1;
                    }else {
                        return false;
                    }
                }
            }
            return count == lockNum;
        }

        public void rotate(List<Dot> keyList, int length){
            for(Dot dot : keyList){
                int x = dot.x;
                int y = dot.y;
                dot.y = x;
                dot.x = length - y;
            }
        }

        class Dot{
            int x;
            int y;
            Dot(int y, int x){
                this.x = x;
                this.y = y;
            }
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        boolean a = s.solution(
//                new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
//                new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}
//        );
//        System.out.println(a);
//    }
}
