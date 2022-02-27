package programmers.level2;

public class Q2개이하로다른비트 {
    /**
     * 이거 너무 어려움
     * 비트 입장에서 1-2개만 바꾸는거
     * 홀수는 제일 작은 처음 0을 바꾸는게 제일 빠르고, 0 뒤에 있는 비트를 1로 바꿔서
     * 최소성 지키기
     */
    class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                long n = numbers[i];
                if(n % 2 == 0) {
                    answer[i] = n + 1;
                }else{
                    long lastZero = (n + 1) & (-n);
                    long zeroOne = n | lastZero;
                    long big = zeroOne & (~lastZero >> 1);
                    answer[i] = big;
                }
            }
            return answer;
        }
    }
}
