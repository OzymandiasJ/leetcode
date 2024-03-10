package 树.二叉树的右视图_199;

import lib.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    /**
     * 给定一个二叉树的 根节点 root，
     * 想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1,3,4]
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        Integer[] arrayName = new Integer[]{1,2,3,null,5,null,4};
        System.out.println(solution.rightSideView(TreeNode.createTree(arrayName)));
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        return bfs(root);
    }
    //同时维护一个level队列，当发生出队时，
    // 如果当前出队的level值不等于上一次出队level就把上一次出队的节点值加入数组
    public List<Integer> bfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueLevel = new LinkedList<>();
        queue.offer(root);
        queueLevel.offer(1);
        int beforeLevel=1;
        TreeNode beforenode=root;
        List<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode currnode = queue.poll();

            int currLevel=queueLevel.poll();

            if(currLevel!=beforeLevel)
                list.add(beforenode.val);
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
        list.add(beforenode.val);
        return list; // 未找到目标节点
    }
}