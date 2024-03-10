package lib;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    /**
     * 根据数组创建树，返回树的根节点
     * @param values 数组
     * @return 树的根节点
     */
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
    /**
     * DFS
     * 给定一个根节点和目标值，找到目标值的节点所在子树
     * @param root 根节点
     * @param target 目标值
     * @return 目标值的节点所在子树
     */
    public static TreeNode DFS_findSubtree(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        TreeNode leftSubtree = BFS_findSubtree(root.left, target);
        TreeNode rightSubtree = BFS_findSubtree(root.right, target);
        if (leftSubtree != null) {
            return leftSubtree;
        }

        if (rightSubtree != null) {
            return rightSubtree;
        }
        return null;
    }

    /**
     * BFS
     * 给定一个根节点和目标值，找到目标值的节点所在子树
     * @param root 根节点
     * @param target 目标值
     * @return 目标值的节点所在子树
     */
    public static TreeNode BFS_findSubtree(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.val == target) {
                return current;
            }

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return null;
    }

    /**
     * 给定一个根节点和目标值，找到根节点到目标节点之间经过的节点值list
     * @param node 根节点
     * @param p 目标节点值
     * @param path 根节点到目标节点之间经过的节点值list
     * @return 是否找到，找不到是因为树种不存在这个节点值
     */
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
