package leetcode.easy;

public class Q206_ReverseLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode node = head;
            ListNode prev = null;
            while(node != null){
                ListNode tmpNode = node.next;
                node.next = prev;
                prev = node;
                node = tmpNode;
            }
            return prev;
        }
    }
}
