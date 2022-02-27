package leetcode.medium;

public class Q11_ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;

            int answer = 0;
            while (left < right){
                int val = Math.min(height[left], height[right]);
                val = val * (right - left);
                answer = Math.max(answer, val);

                if(height[left] > height[right]){
                    right -= 1;
                }else {
                    left += 1;
                }
            }
            return answer;
        }
    }
}
