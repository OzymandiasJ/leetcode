package umsorted.统计好节点_1448;

public class test {
    /**
     * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
     *
     * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        Integer[] values1 = {3,1,4,3,null,1,5};
        TreeNode root1 = TreeNode.createTree(values1);
        System.out.println(solution.goodNodes(root1));
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        return calGoodNodes(root, root.val);
    }

    public int calGoodNodes(TreeNode currNode, int pathMaxVal) {
        if (currNode == null) {
            return 0;
        }

        int count = 0;
        if (currNode.val >= pathMaxVal) {
            count++;
        }

        pathMaxVal = Math.max(pathMaxVal, currNode.val);

        count += calGoodNodes(currNode.left, pathMaxVal);
        count += calGoodNodes(currNode.right, pathMaxVal);

        return count;
    }
}
