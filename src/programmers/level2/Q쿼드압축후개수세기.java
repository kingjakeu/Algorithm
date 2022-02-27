package programmers.level2;

public class Q쿼드압축후개수세기 {
    class Solution {
        int[][] offset = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        public int[] solution(int[][] arr) {
            int n = arr.length;
            Info info = find(0, 0, n, arr);
            return new int[]{info.zero, info.one};
        }
        public Info find(int x, int y, int size, int[][] arr){
            if(size == 2){
                int zero = 0;
                int one = 0;
                for (int i = 0; i < 4; i++) {
                    if(arr[y + offset[i][0]][x + offset[i][1]] == 0){
                        zero += 1;
                    }else{
                        one += 1;
                    }
                }
                Info info = new Info(zero, one);
                info.compress();
                return info;
            }
            Info info = new Info(0, 0);
            int newSize = size / 2;
            info.addInfo(find(x, y, newSize, arr));
            info.addInfo(find(x + newSize, y, newSize, arr));
            info.addInfo(find(x , y + newSize, newSize, arr));
            info.addInfo(find(x + newSize, y + newSize, newSize, arr));
            info.compress();
            return info;
        }
    }
    class Info{
        int zero;
        int one;
        Info(int zero, int one){
            this.zero = zero;
            this.one = one;
        }

        void addInfo(Info info){
            this.zero += info.zero;
            this.one += info.one;
        }
        void compress(){
            if(zero == 0) one = 1;
            else if(one == 0) zero = 1;
        }
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        s.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
//    }
}
