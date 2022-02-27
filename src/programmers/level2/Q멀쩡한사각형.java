package programmers.level2;

public class Q멀쩡한사각형 {
    class Solution {
        public long solution(int w, int h) {
            long answer = (long) w * (long) h;
            int gcb = this.gcb(w, h);
            return answer - (w + h - gcb);
        }

        public int gcb(int x, int y){
            int gcb = 1;
            for (int i = 2; i <= Math.min(x, y); i++) {
                if(x % i == 0 && y % i==0){
                    gcb = i;
                }
            }
            return gcb;
        }
    }
}
