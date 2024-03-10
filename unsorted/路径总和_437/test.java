package umsorted.路径总和_437;

import java.util.HashMap;
import java.util.Map;

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
public class test {
    /**
     * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
     *
     * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        Integer[] values1 = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root1 = TreeNode.createTree(values1);
        System.out.println(solution.pathSum(root1,8));
    }
}

class Solution {
    /**
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     *
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> prefix=new HashMap<>();
        prefix.put(0L,1);
        return dfs(root,prefix,0,targetSum);
    }
    public int dfs(TreeNode root,Map<Long,Integer> prefix,long curr,int targetSum){
        if(root==null){
            return 0;
        }
        int ret=0;
        curr+=root.val;

        ret= prefix.getOrDefault(curr-targetSum,0);
        prefix.put(curr,prefix.getOrDefault(curr,0)+1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}