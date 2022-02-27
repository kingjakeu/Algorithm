package programmers.level3;

import java.util.Stack;

public class Q표편집 {
    class Solution {
        public String solution(int n, int k, String[] cmd) {
            Element root = new Element(0);
            Element prev = root;
            for (int i = 1; i < n; i++) {
                Element element = new Element(i);
                element.prev = prev;
                prev.next = element;
                prev = element;
            }

            Element node = root;
            node = move(node, k);

            Stack<Element> stack = new Stack<>();
            for(String c : cmd){
                if(c.charAt(0) == 'U'){
                    node = move(node, Integer.parseInt(c.substring(2)) * -1);
                }else if(c.charAt(0) == 'D'){
                    node = move(node, Integer.parseInt(c.substring(2)));
                }else if(c.charAt(0) == 'C'){
                    stack.push(node);
                    if(node.prev != null){
                        node.prev.next = node.next;
                    }
                    if(node.next != null){
                        node.next.prev = node.prev;
                    }
                    if(node.next == null){
                        node = node.prev;
                    }else{
                        node = node.next;
                    }
                }else {
                    Element undo = stack.pop();
                    if(undo.prev != null){
                        undo.prev.next = undo;
                    }
                    if(undo.next != null){
                        undo.next.prev = undo;
                    }
                }
            }

            while (node.prev != null){
                node = node.prev;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if(node == null){
                    sb.append("X");
                }else if(node.value == i){
                    sb.append("O");
                    node = node.next;
                }else {
                    sb.append("X");
                }
            }
            return sb.toString();
        }

        public Element move(Element element, int offset){
            if(offset < 0){
                offset = offset * -1;
                for (int i = 0; i < offset; i++) {
                    element = element.prev;
                }
            }else{
                for (int i = 0; i < offset; i++) {
                    element = element.next;
                }
            }
            return element;
        }

        class Element{
            int value;
            Element prev;
            Element next;
            Element(int value){
                this.value = value;
            }
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        String result = s.solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"});
//        System.out.println(result);
//    }
}
