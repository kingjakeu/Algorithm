package programmers.level2;

public class Q양궁대회 {
    class Solution {
        int[] answer;
        int score;
        public int[] solution(int n, int[] info) {
            answer = new int[info.length];
            score = 0;
            find(info.length - 1, n, info, new int[info.length]);
            return score == 0 ? new int[]{-1} : answer;
        }
        public void find(int idx, int n, int[] info, int[] hist){
            if(n < 0) return;
            if(n == 0){
                int[] cal = compute(info, hist);
                int diff = cal[0] - cal[1];
                if(diff > 0 && diff > score){
                    score = diff;
                    for (int i = 0; i < info.length; i++) {
                        answer[i] = hist[i];
                    }
                }
                return;
            }
            if(idx >= 0){
                for (int i = n; i >= 0; i--) {
                    hist[idx] = i;
                    find(idx - 1, n - i, info, hist);
                    hist[idx] = 0;
                }
            }
        }
        public int[] compute(int[] peach, int[] ryan){
            int p = 0;
            int r = 0;
            for (int i = 0; i < peach.length; i++) {
                if(ryan[i] == 0 && peach[i] > 0){
                    p += (10 - i);
                }else if(ryan[i] > 0 && peach[i] == 0){
                    r += (10 - i);
                }else if(ryan[i] > 0 && peach[i] > 0){
                    if(ryan[i] > peach[i]){
                        r += (10 - i);
                    }else{
                        p += (10 - i);
                    }
                }
            }
            return new int[]{r, p};
        }
    }
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] arr = {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
//        int[] ex = {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        s.solution(2, arr);
//
//        int[] a =s.compute(arr, ex);
//        System.out.println(a[0] +" "+ a[1]);
//    }
}
