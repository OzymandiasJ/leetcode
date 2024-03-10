package 树.最大层内元素和_1161;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    /**
     * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，
     * 而根节点的子节点位于第 2 层，依此类推。
     *
     * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
     *
     * 输入：root = [1,7,0,7,-8,null,null]
     * 输出：2
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode root=TreeNode.createTree(new Integer[]{1,7,0,7,-8,null,null});
        System.out.println(solution.maxLevelSum(root));
    }
}
class Solution {
    public int maxLevelSum(TreeNode root) {
        return bfs(root);
    }
    public int bfs(TreeNode root) {
        int sum=0;
        int maxsum=Integer.MIN_VALUE;
        int res=0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueLevel = new LinkedList<>();
        queue.offer(root);
        sum+=root.val;
        queueLevel.offer(1);
        int beforeLevel=1;
        TreeNode beforenode=root;
        while (!queue.isEmpty()) {
            TreeNode currnode = queue.poll();
            int currLevel=queueLevel.poll();

            if(currLevel!=beforeLevel){//新的一个层级
                if(maxsum<sum){
                    maxsum=sum;
                    res=beforeLevel;
                }
                sum=0;
            }
            sum+=currnode.val;
            if (currnode.left != null) {
                queue.offer(currnode.left);
                queueLevel.offer(currLevel+1);
            }
            if (currnode.right != null) {
                queue.offer(currnode.right);
                queueLevel.offer(currLevel+1);
            }
            beforeLevel=currLevel;
            beforenode=currnode;
        }
        if(maxsum<sum){
            maxsum=sum;
            res=beforeLevel;
        }
        return res;
    }
}