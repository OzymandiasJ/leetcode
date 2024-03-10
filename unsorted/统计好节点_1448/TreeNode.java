package umsorted.统计好节点_1448;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

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
