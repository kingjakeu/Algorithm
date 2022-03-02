package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q227_BasicCalculatorII {
    class Solution {
        public int calculate(String s) {
            int length = s.length();
            LinkedList<Integer> numList = new LinkedList<>();
            char op = '+';
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            while (idx < length){
                char c = s.charAt(idx);
                if(Character.isDigit(c)){
                    sb.append(c);
                }

                if((!Character.isWhitespace(c) && !Character.isDigit(c)) || idx == length -1){
                    int num = Integer.parseInt(sb.toString());
                    if(op == '+'){
                        numList.add(num);
                    }else if(op == '-'){
                        numList.add(num * -1);
                    }else if(op == '*'){
                        numList.add(numList.removeLast() * num);
                    }else if(op == '/'){
                        numList.add(numList.removeLast() / num);
                    }
                    sb = new StringBuilder();
                    op = c;
                }
                idx += 1;
            }

            int val = 0;
            for(int num : numList){
                val += num;
            }
            return val;
        }
    }
}
