package programmers.level2;

public class Q삼각달팽이 {
    class Solution {
        int[] sumArr;
        int[] inArr;
        public int[] solution(int n) {
            sumArr = new int[n + 1];
            inArr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sumArr[i] = sumArr[i-1] + i;
                inArr[i] = inArr[i-1] + (i * 4);
            }
            int[] answer = new int[sumArr[n]];
            fill(0, n, 1, n, answer);
            return answer;
        }
        public void fill(int start, int end, int count, int n, int[] answer){
            int idx = inArr[start];
            if(count > answer.length) return;
            answer[idx] = count++;
            for (int i = 1; i < n; i++) {
                idx += (start * 2) + i;
                answer[idx] = count++;
            }
            for (int i = 0; i < n - 1; i++) {
                idx += 1;
                answer[idx] = count++;
            }
            for (int i = 1; i <= n - 2; i++) {
                answer[sumArr[end - i] - (start + 1)] = count++;
            }
            fill(start + 1, end - 1, count, n - 3, answer);

        }
    }
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.solution(6);
//    }
}
