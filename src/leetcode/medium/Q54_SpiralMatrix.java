package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * #coupang
 */
public class Q54_SpiralMatrix {
    class Solution {
        int[][] offset = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int m;
        int n;
        List<Integer> answer;
        int[][] mat;
        public List<Integer> spiralOrder(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            mat = matrix;
            answer = new ArrayList<>();

            boolean[][] visited = new boolean[m][n];
            visited[0][0] = true;
            answer.add(mat[0][0]);
            find(0, 0, 0, visited);

            return answer;
        }

        public void find(int x, int y, int off, boolean[][] visited){
            if(answer.size() == m * n) return;
            int dx = x + offset[off][0];
            int dy = y + offset[off][1];
            if(dx >= 0 && dx < n && dy >= 0 && dy< m && !visited[dy][dx]){
                visited[dy][dx] = true;
                answer.add(mat[dy][dx]);
                find(dx, dy, off, visited);
            }else{
                off = off + 1 < 4 ? off + 1 : 0;
                find(x, y, off, visited);
            }
        }
    }
}
