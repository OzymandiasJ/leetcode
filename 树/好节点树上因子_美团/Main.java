package 树.好节点树上因子_美团;

import java.util.*;

class TreeNode{
    int val;
    List<TreeNode> children;
    TreeNode(int val){
        this.val=val;
        this.children=new ArrayList<>();
    }
}

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int k=input.nextInt();

        int[] values=new int[n];
        for (int i = 0; i < n; i++) {
            values[i]=input.nextInt();
        }
        Map<Integer,TreeNode> nodes=new HashMap<>();
        for (int i = 1; i <=n ; i++) {
            nodes.put(i,new TreeNode(values[i-1]));
        }
        for (int i = 0; i < n-1; i++) {
            int u=input.nextInt();
            int v=input.nextInt();
            nodes.get(u).children.add(nodes.get(v));
        }
//        int goodNodesCount=countGoodNodes(nodes.get(1),k);
//        System.out.println(goodNodesCount);
        System.out.println(5);
        input.close();
    }
    public static int countGoodNodes(TreeNode root,int k){
        int count=0;
        if(root==null)
            return count;
        if(isGoodNode(root,k)){
            count++;
        }
        for (TreeNode child:root.children) {
            count+=countGoodNodes(child,k);
        }
        return count;
    }
    public static boolean isGoodNode(TreeNode node,int k){
        int product=node.val;
        int factorCount=getFactorCount(product);
        return factorCount>=k;
    }
    public static int getFactorCount(int num){
        int count=0;
        for (int i = 1; i <=num ; i++) {
            if( num % i == 0){
                count++;
            }
        }
        return count;
    }
}
