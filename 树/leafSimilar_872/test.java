package 树.leafSimilar_872;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Solution solution=new Solution();
        Integer[] values1 = {3, 5, 1, 6, 2, 9, 8, null, null, 7, 4};
        Integer[] values2 = {3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};
        TreeNode root1 = TreeNode.createTree(values1);
        TreeNode root2 = TreeNode.createTree(values2);
        System.out.println(solution.leafSimilar(root1,root2));
    }

}
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<Integer>();
        if (root1 != null) {
            dfs(root1, seq1);
        }

        List<Integer> seq2 = new ArrayList<Integer>();
        if (root2 != null) {
            dfs(root2, seq2);
        }

        return seq1.equals(seq2);
    }
    public void dfs(TreeNode node, List<Integer> seq){
        if(node.left==null&&node.right==null){
            seq.add(node.val);
        }else {
            if(node.left!=null){
                dfs(node.left,seq);
            }
            if(node.right!=null){
                dfs(node.right,seq);
            }
        }
    }
}
class TreeNode {
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
    public static TreeNode createTree(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        return createNode(values, 0);
    }

    private static TreeNode createNode(Integer[] values, int index) {
        if (index >= values.length || values[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(values[index]);
        node.left = createNode(values, 2 * index + 1);
        node.right = createNode(values, 2 * index + 2);

        return node;
    }
}



