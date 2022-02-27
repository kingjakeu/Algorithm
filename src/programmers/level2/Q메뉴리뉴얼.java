package programmers.level2;

import java.util.*;

public class Q메뉴리뉴얼 {
    class Solution {
        Map<Integer, Set<String>> keyIndexMap;
        Map<String, Integer> courseMap;
        public String[] solution(String[] orders, int[] course) {
            keyIndexMap = new HashMap<>();
            for(int c : course){
                keyIndexMap.put(c, new HashSet<>());
            }

            courseMap = new HashMap<>();
            for(String order : orders){
                char[] menu = order.toCharArray();
                for (int i = 2; i <= menu.length; i++) {
                    find(0, i, "", menu);
                }
            }

            List<String> menuList = new ArrayList<>();
            for(Map.Entry<Integer, Set<String>> entry : keyIndexMap.entrySet()){
                int maxCount = 0;
                List<String> tempList = new ArrayList<>();
                for(String menu : entry.getValue()){
                    int count = courseMap.get(menu);
                    if(count >= 2){
                        if(maxCount < count){
                            tempList = new ArrayList<>();
                            tempList.add(menu);
                            maxCount = count;
                        }else if(maxCount == count){
                            tempList.add(menu);
                        }
                    }
                }
                menuList.addAll(tempList);
            }
            Collections.sort(menuList);
            return menuList.toArray(new String[menuList.size()]);
        }

        public void find(int idx, int max, String cur, char[] menu){
            if(cur.length() == max){
                char[] tmp =  cur.toCharArray();
                Arrays.sort(tmp);
                String key = String.valueOf(tmp);
                if(courseMap.containsKey(key)){
                    courseMap.put(key, courseMap.get(key) + 1);
                }else{
                    courseMap.put(key, 1);
                }
                if(keyIndexMap.containsKey(max)){
                    keyIndexMap.get(max).add(key);
                }
            }
            for (int i = idx; i < menu.length; i++) {
                find(i + 1, max, cur + menu[i], menu);
            }
        }
    }
}
