package 树.删除二叉搜索树中的节点_450;
import lib.TreeNode;
public class Main {
    /**
     *给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
     * 并保证二叉搜索树的性质不变。
     * 返回二叉搜索树（有可能被更新）的根节点的引用。
     * @param args
     */
    public static void main(String[] args) {
    Solution solution=new Solution();
        TreeNode root=TreeNode.createTree(new Integer[]{5,3,6,2,4,null,7});
        System.out.println(solution.deleteNode(root,3).val);
    }
}
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}
