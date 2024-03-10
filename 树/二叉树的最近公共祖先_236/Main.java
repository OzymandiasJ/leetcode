package 树.二叉树的最近公共祖先_236;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
     * 最近公共祖先表示为一个节点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        Integer[] arrayName = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        System.out.println(solution.lowestCommonAncestor(TreeNode.createTree(arrayName),new TreeNode(5),new TreeNode(1)).val);
    }
}
class Solution {
    /**
     * 先找到这俩节点，并向上遍历节点记录起来，记录成两个list，返回两个list第一个相同的值即可
     */
    ArrayList<Integer> listp=new ArrayList<>();
    ArrayList<Integer> listq=new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //先dfs找到这俩节点,在dfs过程中需要记录所有过程节点
        dfs(root,p.val,listp);
        dfs(root,q.val,listq);
        for (int i = 0; i < listp.size(); i++) {//从list末尾开始，因为约末尾越靠近目标节点
            if(listq.contains(listp.get(listp.size()-i-1)))
                return new TreeNode(listp.get(listp.size()-i-1));
        }
        return null;
    }
    private boolean dfs(TreeNode node, int p, List<Integer> path) {
        if (node == null)
            return false;
        path.add(node.val);
        if (node.val == p)
            return true;
        if (dfs(node.left, p, path) || dfs(node.right, p, path)) {
            return true;
        }
        // 如果不是目标节点，需要将当前节点从路径中移除
        path.remove(path.size() - 1);
        return false;
    }

}