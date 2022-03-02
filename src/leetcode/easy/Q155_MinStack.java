package leetcode.easy;

public class Q155_MinStack {
    class MinStack {
        Node[] arr;
        int idx;
        int minVal;
        public MinStack() {
            arr = new Node[30000];
            minVal = Integer.MAX_VALUE;
            idx = -1;
        }

        public void push(int val) {
            arr[++idx] = new Node(val, minVal);
            minVal = Math.min(minVal, val);
        }

        public void pop() {
            if(idx >= 0){
                minVal = arr[idx--].prevMin;
            }
        }

        public int top() {
            return arr[idx].val;
        }

        public int getMin() {
            return minVal;
        }

        class Node{
            int val;
            int prevMin;
            Node(int val, int prevMin){
                this.val = val;
                this.prevMin = prevMin;
            }
        }
    }
}
