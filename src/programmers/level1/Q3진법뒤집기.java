package programmers.level1;

import java.util.Stack;

public class Q3진법뒤집기 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            while (n > 0){
                int r = n % 3;
                stack.push(r);
                n = n / 3;
            }
            String newN = sb.toString();
            int offset = 1;
            while(!stack.isEmpty()){
                answer += stack.pop() * offset;
                offset *= 3;
            }
            return answer;
        }
    }
}
