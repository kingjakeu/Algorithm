package programmers.level3;

import java.util.*;

public class Q셔틀버스 {
    static class Solution {
        public String solution(int n, int t, int m, String[] timetable) {
            List<Integer> crewList = new ArrayList<>();
            for(String timeT : timetable){
                String[] split = timeT.split(":");
                int arrTime = 60 * Integer.parseInt(split[0]);
                arrTime += Integer.parseInt(split[1]);
                crewList.add(arrTime);
            }
            Collections.sort(crewList);

            int startTime = (60 * 9) - t;
            int idx = 0;
            int size = crewList.size();
            int remain = m;
            for (int i = 0; i < n; i++) {
                startTime += t;
                for (remain = m; remain > 0; remain--) {
                    if (idx >= size) break;
                    int crewTime = crewList.get(idx);
                    if (crewTime > startTime) break;
                    idx += 1;
                }
            }

            int result = startTime;

            if(remain == 0){
                idx -= 1;
                result = crewList.get(idx);
                result -= 1;
            }

            int hour = result / 60;
            int min = result % 60;
            return (hour < 10 ? "0" + hour : String.valueOf(hour))
                    + ":"
                    + (min < 10 ? "0" + min : String.valueOf(min));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1, 1, 5,
                new String[]{"08:00", "08:01", "08:02", "08:03"}));

        System.out.println(s.solution(2, 10, 2,
                new String[]{"09:10", "09:09", "08:00"}));

        System.out.println(s.solution(2, 1, 2,
                new String[]{"09:00", "09:00", "09:00", "09:00"}));

        System.out.println(s.solution(10, 60, 45,
                new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));

        System.out.println(s.solution(1, 1, 1,
                new String[]{"09:00", "09:05"}));

    }
}
