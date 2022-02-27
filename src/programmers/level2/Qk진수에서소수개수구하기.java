package programmers.level2;

public class Qk진수에서소수개수구하기 {
    class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            String bitString = toKBitString(n, k);
            int start = 0;
            int length = bitString.length();
            for (int i = 1; i < length; i++) {
                if(bitString.charAt(i) == '0'){
                    if(start < i){
                        String s = bitString.substring(start, i);
                        if(isPrime(s)){
                            answer += 1;
                        }
                    }
                    start = i + 1;
                }
            }
            if(start < length){
                if(isPrime(bitString.substring(start, length))){
                    answer += 1;
                }
            }
            return answer;
        }

        public String toKBitString(int n, int k){
            StringBuilder sb = new StringBuilder();
            while (n > k){
                sb.insert(0, n % k);
                n = n / k;
            }
            sb.insert(0, n % k);
            return sb.toString();
        }

        public boolean isPrime(String s){
            long n = Long.parseLong(s);
            if (n < 2) return false;
            for (long i = 2; i * i <= n; i++) {
                if(n % i == 0) return false;
            }
            return true;
        }
    }
}
