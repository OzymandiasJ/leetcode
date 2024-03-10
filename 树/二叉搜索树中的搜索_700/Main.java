package 树.二叉搜索树中的搜索_700;

import lib.*;

public class Main {
    /**
     * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
     *
     * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode root=TreeNode.createTree(new Integer[]{18,2,22,null,null,null,63,null,84,null,null});
        System.out.println(solution.searchBST(root,63).val);
    }
}
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val==val)
            return root;
        else if(root.left!=null&&root.val>val) {
            return searchBST(root.left,val);
        }else if(root.right!=null&&root.val<val){
            return searchBST(root.right,val);
        }else
            return null;
    }
}