package 树.二叉树中的最长交错路径_1372;

import lib.TreeNode;

public class Main {
    /**
     * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
     *
     * 选择二叉树中 任意 节点和一个方向（左或者右）。
     * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
     * 改变前进方向：左变右或者右变左。
     * 重复第二步和第三步，直到你在树中无法继续移动。
     * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
     *
     * 请你返回给定树中最长 交错路径 的长度。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        Integer[] arrayName = new Integer[]{1,null,1,1,1,null,null,1,1,null,1,null,null,null,1};
        System.out.println(solution.longestZigZag(TreeNode.createTree(arrayName)));
    }
}
class Solution2 {
    int maxdepth=0;
    public int longestZigZag(TreeNode root) {
        bfs(root);
        return maxdepth;
    }
    public void bfs(TreeNode root){
        if(root==null){
            return;
        }else {
            maxdepth=Math.max(maxdepth,Math.max(solve(root,0),solve(root,1)));
        }

        if(root.left==null&&root.right==null){
            return;
        }else{
            bfs(root.left);
            bfs(root.right);
        }
    }
    public int solve(TreeNode root,int tag){
        //tag==0表示是父节点的左节点,tag==1表示是右节点，
        if(root==null)
            return 1;
        else {
            if(tag==0){//从左边来的，走右节点
                return solve(root.left,1)+1;
            }else {    //从右边来的，走左节点
                return solve(root.right,0)+1;
            }
        }
    }
}
class Solution {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        f(root,0,0);
        f(root,1,0);
        return ans;
    }
    // dir = 0 表示上个节点是向左的
    // dir = 1 表示上个节点是向右的
    void f(TreeNode root , int dir , int depth){
        if(root == null) return ;
        ans = Math.max(ans,depth);
        if(dir==0){
            f(root.right,1,depth+1);   //  继续上面的路线
            f(root.left,0,0+1);        //  以当前节点为起点，重新开辟一条路线  此时depth = 0  就是0+1
        }else{
            f(root.left,0,depth+1);    //  继续上面的路线
            f(root.right,1,0+1);       //  以当前节点为起点，重新开辟一条路线
        }
    }
}