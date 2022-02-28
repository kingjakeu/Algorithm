package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q438_FindAllAnagramsInAString {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int sLength = s.length();
            int pLength = p.length();
            int[] pCount = new int[26];
            for (int i = 0; i < pLength; i++) {
                pCount[p.charAt(i) - 'a'] += 1;
            }

            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < sLength - pLength; i++) {
                if (check(i, s, pCount, pLength)){
                    answer.add(i);
                }
            }
            return answer;
        }

        public boolean check(int idx, String s, int[] pCount, int pLength){
            int[] sCount = new int[26];
            for (int j = 0; j < pLength; j++) {
                int tmpIdx = s.charAt(idx + j) - 'a';
                sCount[tmpIdx] += 1;
                if(pCount[tmpIdx] < sCount[tmpIdx]){
                    return false;
                }
            }
            return true;
        }
    }
}
