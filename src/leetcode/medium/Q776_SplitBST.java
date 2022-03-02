package leetcode.medium;

public class Q776_SplitBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        /**
         *[0] - is <= than target
         *[1] - is > than target
         **/
        public TreeNode[] splitBST(TreeNode root, int target) {
            TreeNode[] treeNodes = new TreeNode[2];
            if(root == null) return treeNodes;

            if(root.val <= target){;
                TreeNode[] result = splitBST(root.right, target);
                treeNodes[0] = root;
                treeNodes[1] = result[1];
                root.right = result[0];// less than target, in right node becomes nodes right
            }else{
                TreeNode[] result = splitBST(root.left, target);
                treeNodes[0] = result[0];
                treeNodes[1] = root;
                root.left = result[1];
            }

            return treeNodes;
        }
    }
}
