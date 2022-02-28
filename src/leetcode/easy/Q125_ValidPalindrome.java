package leetcode.easy;

public class Q125_ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder();

            char offset = 'a' - 'A';
            for(char c : s.toCharArray()){
                if(('a' <= c && c <= 'z') || ('0' <= c && c <= '9')){
                    sb.append(c);
                }else if('A' <= c && c <= 'Z'){
                    char newC = (char)(c + offset);
                    sb.append(newC);
                }
            }
            String newS = sb.toString();
            int length = newS.length();
            if(length <= 1) return true;

            for(int i = 0; i <= length / 2; i++){
                if(newS.charAt(i) != newS.charAt(length - i -1)) return false;
            }

            return true;
        }
    }
}
