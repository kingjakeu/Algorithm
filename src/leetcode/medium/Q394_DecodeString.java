package leetcode.medium;

import java.util.Stack;

public class Q394_DecodeString {
    class Solution {
        public String decodeString(String s) {
            int length = s.length();
            Stack<Integer> numStack = new Stack<>();
            Stack<String> wordStack = new Stack<>();

            StringBuilder numBuff = new StringBuilder();
            StringBuilder charBuff = new StringBuilder();
            for(int i = 0; i < length; i++){
                char c = s.charAt(i);

                if(Character.isDigit(c)){
                    numBuff.append(c);
                }else if(Character.isAlphabetic(c)){
                    charBuff.append(c);
                }else if(c == '['){
                    numStack.add(Integer.parseInt(numBuff.toString()));
                    wordStack.add(charBuff.toString());
                    charBuff = new StringBuilder();
                    numBuff = new StringBuilder();
                }else if(c == ']'){
                    int val = numStack.pop();
                    String word = charBuff.toString();
                    for(int j = 1; j < val; j++){
                        charBuff.append(word);
                    }
                    charBuff.insert(0, wordStack.pop());
                }
            }

            return charBuff.toString();
        }
    }
}
