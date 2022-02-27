package programmers.level2;

public class Q이진변환반복하기 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];
            while(!s.equals("1")){
                StringBuilder sb = new StringBuilder();
                for(char c : s.toCharArray()){
                    if(c == '0'){
                        answer[1] += 1;
                    }else {
                        sb.append(c);
                    }
                }
                int length = sb.length();
                s = Integer.toBinaryString(length);
                answer[0] += 1;
            }
            return answer;
        }
    }
}
