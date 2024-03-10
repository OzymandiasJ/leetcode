package 树.二叉树的最大深度_104;

import lib.TreeNode;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        Integer[] arrayName = new Integer[]{1,null,3};
        System.out.println(solution.maxDepth(TreeNode.createTree(new Integer[]{1,null,2})));
    }
}
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else {
            return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
        }
    }
}