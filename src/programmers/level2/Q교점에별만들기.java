package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Q교점에별만들기 {
    class Solution {
        public String[] solution(int[][] line) {
            int length = line.length;
            List<long[]> setList = new ArrayList<>();
            long minX = Long.MAX_VALUE;
            long maxX = Long.MIN_VALUE;
            long minY = Long.MAX_VALUE;
            long maxY = Long.MIN_VALUE;
            for (int i = 0; i < length - 1; i++) {
                for (int j = i + 1; j < length; j++) {
                    double divisor = ((long)line[i][0] * (long)line[j][1]) - ((long)line[i][1] * (long)line[j][0]);
                    if(divisor != 0){
                        double x = ((long)line[i][1] * (long)line[j][2]) - ((long)line[i][2] * (long)line[j][1]);
                        x = x / divisor;
                        double y = ((long)line[i][2] * (long)line[j][0]) - ((long)line[i][0] * (long)line[j][2]);
                        y = y / divisor;
                        if(x == Math.floor(x) && y == Math.floor(y) && Double.isFinite(x) && Double.isFinite(y)){
                            long[] sets = {(long) x, (long) y};
                            minX = (long) Math.min(minX, x);
                            maxX = (long) Math.max(maxX, x);
                            minY = (long) Math.min(minY, y);
                            maxY = (long) Math.max(maxY, y);
                            setList.add(sets);
                        }
                    }
                }
            }

            long xLength = maxX - minX + 1;
            long yLength = maxY - minY + 1;
            char[][] answer = new char[(int) yLength][(int) xLength];
            for (int i = 0; i < yLength; i++) {
                for (int j = 0; j < xLength; j++) {
                    answer[i][j] = '.';
                }
            }
            for(long[] sets : setList){
                int dx = (int) (sets[0] - minX);
                int dy = (int) (maxY - sets[1]);
                answer[dy][dx] = '*';
            }
            String[] stringAns = new String[(int) yLength];
            for (int i = 0; i < yLength; i++) {
                stringAns[i] = String.valueOf(answer[i]);
            }
            return stringAns;
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[][] lines = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
//        s.solution(lines);
//    }
}
