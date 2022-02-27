package leetcode.medium;

import java.util.List;

public class Q82_RemoveDuplicatesFromSortedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null) return null;
            ListNode answer = new ListNode();

            ListNode prev = answer;
            ListNode node = head;

            while (node != null){
                ListNode next = node.next;
                while (next != null && node.val == next.val){
                    node = removeDup(node);
                    if(node == null) {
                        next = null;
                        break;
                    }
                    next = node.next;
                }
                prev.next = node;
                prev = node;
                node = next;
            }
            return answer.next;
        }

        public ListNode removeDup(ListNode node){
            ListNode next = node.next;
            if(next != null && node.val == next.val){
                return removeDup(next);
            }else{
                return next;
            }
        }
    }
}
