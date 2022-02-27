package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class Q숫자문자열과영단어 {
    class Solution {
        public int solution(String s) {
            StringBuilder sb = new StringBuilder();
            Map<String, Integer> wordMap = new HashMap<>(Map.of(
                    "zero", 0, "one", 1, "two", 2, "three", 3, "four", 4,
                    "five", 5, "six", 6, "seven", 7, "eight", 8, "nine", 9));
            int lastIdx = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    sb.append(s.charAt(i));
                    lastIdx = i+1;
                }else{
                    if(wordMap.containsKey(s.substring(lastIdx, i + 1))){
                        sb.append(wordMap.get(s.substring(lastIdx, i+1)));
                        lastIdx = i+1;
                    }
                }
            }
            return Integer.parseInt(sb.toString());
        }
    }
}
