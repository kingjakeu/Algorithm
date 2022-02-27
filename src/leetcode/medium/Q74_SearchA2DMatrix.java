package leetcode.medium;

public class Q74_SearchA2DMatrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int height = matrix.length;
            int width = matrix[0].length;

            int left = 0;
            int right = height - 1;
            while (left < right){
                int mid = (left + right) / 2;
                if(matrix[mid][width - 1] >= target){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }

            int[] mat = matrix[left];
            left = 0;
            right = width - 1;
            while (left <= right){
                int mid = (left + right) / 2;
                if(mat[mid] == target) {
                    return true;
                }
                if(left == right) return false;
                if(mat[mid] > target){
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
}
