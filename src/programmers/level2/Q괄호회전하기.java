package programmers.level2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q괄호회전하기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            List<Character> charList = new LinkedList<>();
            for(char c : s.toCharArray()){
                charList.add(c);
            }
            for (int i = 0; i < s.length(); i++) {
                if(isValid(charList)) answer += 1;
                charList.add(charList.remove(0));
            }
            return answer;
        }

        public boolean isValid(List<Character> charList){
            Stack<Character> front = new Stack<>();
            for(char c : charList){
                if(c == '[' || c == '{' || c == '('){
                    front.push(c);
                }else {
                    if (front.isEmpty()) return false;
                    char peek = front.pop();
                    if ((c == ']' && peek != '[')
                        || (c == '}' && peek != '{')
                        || (c == ')' && peek != '(')){
                        return false;
                    }
                }
            }
            return front.isEmpty();
        }
    }
}
