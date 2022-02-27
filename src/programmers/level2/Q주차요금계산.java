package programmers.level2;

import java.util.*;

public class Q주차요금계산 {
    class Solution {
        public int[] solution(int[] fees, String[] records) {
            Map<String, Integer> useMap = new HashMap<>();
            Map<String, Integer> parkMap = new HashMap<>();

            for(String rec : records){
                String[] split = rec.split(" ");
                if("IN".equals(split[2])){
                    parkMap.put(split[1], toMinute(split[0]));
                }else{
                    int totalMin = toMinute(split[0]);
                    String key = split[1];
                    totalMin = totalMin - parkMap.remove(key);
                    if(useMap.containsKey(key)){
                        useMap.put(key, useMap.get(key) + totalMin);
                    }else{
                        useMap.put(key, totalMin);
                    }
                }
            }
            for(Map.Entry<String, Integer> entry : parkMap.entrySet()){
                int totalMin = toMinute("23:59") - entry.getValue();
                if(useMap.containsKey(entry.getKey())){
                    useMap.put(entry.getKey(), useMap.get(entry.getKey()) + totalMin);
                }else{
                    useMap.put(entry.getKey(), totalMin);
                }
            }

            List<String> userList = new ArrayList<>(useMap.keySet());
            Collections.sort(userList);

            int[] answer = new int[userList.size()];
            for (int i = 0; i < answer.length; i++) {
                int minute = useMap.get(userList.get(i));
                minute = Math.max(0, minute - fees[0]);

                int cost = fees[1];
                cost += Math.ceil((double) minute/ fees[2]) * fees[3];
                answer[i] = cost;
            }

            return answer;
        }

        public int toMinute(String s){
            String[] sp = s.split(":");
            int minute = 0;
            minute += (60 * Integer.parseInt(sp[0]));
            minute += Integer.parseInt(sp[1]);
            return minute;
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int[] fee = {180, 5000, 10, 600};
//        String[] rec = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//        s.solution(fee, rec);
//    }
}
