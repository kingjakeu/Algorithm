package programmers.level3;

import java.util.HashMap;
import java.util.Map;

public class Q다단계칫솔판매 {
    static class Solution {
        Map<String, Member> memberMap;
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int[] answer = new int[enroll.length];
            memberMap = new HashMap<>();
            for (int i = 0; i < enroll.length; i++) {
                memberMap.put(enroll[i], new Member(enroll[i], memberMap.get(referral[i])));
            }

            for (int i = 0; i < seller.length; i++) {
                divideMoney(seller[i], amount[i] * 100);
            }

            for (int i = 0; i < enroll.length; i++) {
                answer[i] = memberMap.get(enroll[i]).money;
            }
            return answer;
        }

        public void divideMoney(String name, int amount){
            int fee = (int) (amount * 0.1);

            Member member = memberMap.get(name);
            member.money += amount - fee;

            if(member.parent != null && fee > 0){
                divideMoney(member.parent.name, fee);
            }
        }
    }
    static class Member{
        String name;
        int money;
        Member parent;
        Member(String name, Member parent){
            this.name = name;
            this.money = 0;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}
        );
    }
}
