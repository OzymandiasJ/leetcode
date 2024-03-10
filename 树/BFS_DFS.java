package 树;

import lib.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_DFS {
    public static void main(String[] args) {
        Solution solution=new Solution();
        TreeNode root=TreeNode.createTree(new Integer[]{5,4,3,3,2,6,7});
        System.out.println(solution.dfsSearch(root,7).val);
    }
}
class Solution {
    // BFS 搜索目标节点,迭代
    public TreeNode bfsSearch(TreeNode root, int target) {
        /**
         *        5
         *      4    3
         *    3  2  6  7
         * bfs查找节点7
         * 根节点5入队——5
         *
         * 5出队，不是目标节点——empty
         * 左右孩子入队——43
         *
         * 4出队，不是目标节点——3
         * 左右孩子入队——332
         *
         * 3出队，不是目标节点——32
         * 左右孩子入队——3267
         *
         * 3出队，不是目标节点——267
         * 无孩子——267
         *
         * 2出队，不是目标节点——67
         * 无孩子——67
         *
         * 6出队，不是目标节点——7
         * 无孩子——7
         *
         * 7出队，是目标节点返回
         *
         * 若队列空，结束循环
         */
        //bfs思路：
        // 1,根节点入队，
        // 2，while（队列不为空）开始循环
        // 3，出队一个节点，如果该节点==目标值直接返回该节点
        // 4，如果左孩子不为空将左孩子入队，如果右孩子不为空将右孩子入队 ，
        // 5，进入下一轮循环

        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.val == target) {
                return node;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return null; // 未找到目标节点
    }
    // DFS 搜索目标节点（使用递归）
    public TreeNode dfsSearch(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        if (root.val == target) {
            return root;
        }

        TreeNode leftResult = dfsSearch(root.left, target);
        if (leftResult != null) {
            return leftResult;
        }

        TreeNode rightResult = dfsSearch(root.right, target);
        if (rightResult != null) {
            return rightResult;
        }

        return null; // 未找到目标节点
    }
}
