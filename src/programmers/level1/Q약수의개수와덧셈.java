package programmers.level1;

public class Q약수의개수와덧셈 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for (int i = left; i <= right ; i++) {
                int count = countDivisor(i);
                answer = count % 2 == 0  ? answer + i : answer - i;
            }
            return answer;
        }
        public int countDivisor(int n){
            int sqrt = (int) Math.sqrt(n);
            int count = 0;
            for (int i = 1; i <= sqrt ; i++) {
                if(n % i == 0){
                    if(n / i == i) count +=1;
                    else count += 2;
                }
            }
            return count;
        }
    }
}
