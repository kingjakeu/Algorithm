package programmers.level2;

import java.util.*;

public class Q순위검색 {
    class Solution {
        public int[] solution(String[] info, String[] query) {
            Node root = new Node("");

            for(String inf : info){
                String[] split = inf.split(" ");
                Node node = root.addChild(split[0]);
                for (int i = 1; i <= 3; i++) {
                    node = node.addChild(split[i]);
                }
                node.addScore(split[4]);
                Collections.sort(node.scoreList);
            }

            int[] answer = new int[query.length];
            for (int i = 0; i < query.length; i++) {
                String q = query[i];
                String[] split = q.split(" ");
                answer[i] = findQualifier(split, 0, root);
            }
            return answer;
        }

        public int findQualifier(String[] split, int idx, Node node){
            if(idx == 8){
                int minScore = Integer.parseInt(split[7]);
                int size = node.scoreList.size();
                for (int i = 0; i < node.scoreList.size(); i++) {
                    if(node.scoreList.get(i) >= minScore) {
                        return size - i;
                    }
                }
                return 0;
            }

            int count = 0;
            String key = split[idx];
            if(key.equals("-")){
                for(Node child : node.childList){
                    count += findQualifier(split, idx + 2, child);
                }
            }else{
                Node child = node.getChild(key);
                if(child != null) {
                    count += findQualifier(split, idx + 2, child);
                }
            }
            return count;
        }
    }

    class Node{
        String key;
        List<Node> childList;
        List<Integer> scoreList;

        Node(String key){
            this.key = key;
            this.childList = new ArrayList<>();
        }

        void addScore(String key){
            if(this.scoreList == null) this.scoreList = new ArrayList<>();
            this.scoreList.add(Integer.parseInt(key));
        }

        Node addChild(String key){
            Node node = this.getChild(key);
            if(node == null){
                node = new Node(key);
                this.childList.add(node);
            }
            return node;
        }

        Node getChild(String key){
            for(Node node : childList){
                if(node.key.equals(key)){
                    return node;
                }
            }
            return null;
        }
    }
}
