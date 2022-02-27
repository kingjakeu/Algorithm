package programmers.level2;

public class Q배달 {
    class Solution {
        int[][] costMap;
        public int solution(int N, int[][] road, int K) {
            int answer = 0;
            int MAX = 500001;
            costMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i == j) {
                        costMap[i][j] = 0;
                    }else{
                        costMap[i][j] = MAX;
                    }
                }
            }
            for(int[] r : road){
                int left = r[0] - 1;
                int right = r[1] - 1;
                costMap[left][right] = Math.min(costMap[left][right], r[2]);
                costMap[right][left] = Math.min(costMap[right][left], r[2]);
            }

            boolean[] visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                int smallIdx = -1;
                for (int j = 0; j < N; j++) {
                    if(!visited[j]){
                        if (smallIdx == -1) smallIdx = j;
                        if (costMap[0][j] < costMap[0][smallIdx]){
                            smallIdx = j;
                        }
                    }
                }
                visited[smallIdx] = true;
                for (int j = 0; j < N; j++) {
                    costMap[0][j] = Math.min(costMap[0][j], costMap[0][smallIdx] + costMap[smallIdx][j]);
                }
            }
            for (int i = 0; i < N; i++) {
                if(costMap[0][i] <= K) {
                    answer += 1;
                }
            }
            return answer;
        }
    }
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
//        System.out.println(s.solution(5, road, 3));
//    }
}
