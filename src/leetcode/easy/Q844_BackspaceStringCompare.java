package leetcode.easy;

public class Q844_BackspaceStringCompare {
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            int sIdx = s.length() - 1;
            int tIdx = t.length() - 1;

            while (sIdx >= 0 || tIdx >= 0){
                int sLeft = sIdx;
                for (int i = sIdx; i >= sLeft && i >= 0; i--) {
                    if(s.charAt(i) == '#'){
                        sLeft -= 2;
                    }
                }
                sIdx = sLeft;

                int tLeft = tIdx;
                for (int i = tIdx; i >= tLeft && i >= 0; i--) {
                    if(t.charAt(i) == '#'){
                        tLeft -= 2;
                    }
                }
                tIdx = tLeft;

                if(sIdx < 0 || tIdx < 0) break;
                if(s.charAt(sIdx) != t.charAt(tIdx)){
                    return false;
                }
                sIdx -= 1;
                tIdx -= 1;
            }
            return sIdx < 0 && tIdx < 0;
        }
    }
}
