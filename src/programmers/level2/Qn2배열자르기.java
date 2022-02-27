package programmers.level2;

public class Qn2배열자르기 {
    class Solution {
        public int[] solution(int n, long left, long right) {
            long length = right - left + 1;
            int[] answer = new int[(int) length];

            for (int i = 0; i < length; i++) {
                long num = left + i;
                int h = (int) (num / n);
                long m = ((long) n * h) + h;
                if(num <= m){
                    answer[i] = h + 1;
                }else {
                    answer[i] = (int) (h + 1 + (num - m));
                }
            }
            return answer;
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.solution(3, 0, 8);
//    }
}
