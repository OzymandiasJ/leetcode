package 图.统计无向图中无法互相到达点对数_2316;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /**
         * 给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。
         * 同时给你一个二维整数数组 edges ，
         * 其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
         * 请你返回 无法互相到达 的不同 点对数目 。
         */
        Solution solution=new Solution();
        System.out.println(solution.countPairs(5,new int[][]{
                {1, 0},
                {3, 1},
                {0, 4},
                {2, 1}}));
    }
}

class Solution {
    int dfsCount;
    ArrayList<Boolean> vis=new ArrayList<Boolean>();//初始值为false
    public long countPairs(int n, int[][] edges) {
//        设置vis数组，只要数组含有false没遍历过的节点就继续从没遍历的节点开始dfs，直到为空
//        每次判断时候count++，表示多了一个子图
        //最后相乘即可

        ArrayList<Integer> subGraph=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vis.add(false);
        }
        for (int i = 0; i < n; i++) {
            //只要数组含有false没遍历过的节点就继续从没遍历的节点开始dfs
            if(!vis.contains(false))
                break;
            dfsCount=0;
            if(vis.get(i)==false)//没遍历就以该节点为起点开始dfs
                dfs(n,edges,i);
            if(dfsCount>0)
                subGraph.add(dfsCount);
        }
        Long res=0l;
        for (int i = 0; i < subGraph.size(); i++) {
            for (int j = i+1; j < subGraph.size(); j++) {
                res+=subGraph.get(i)*subGraph.get(j);
            }
        }
        return res;
    }
    public void dfs(int n, int[][] edges,int nodeIndex){
        if(vis.get(nodeIndex)==false){
            dfsCount++;
            vis.set(nodeIndex,true);
        }else
            return;

        for (int i = 0; i < edges.length; i++) {
            if(edges[i][0]==nodeIndex&& !vis.get(edges[i][1])){
                dfs(n,edges,edges[i][1]);
            }
            if(edges[i][1]==nodeIndex&& !vis.get(edges[i][0])){
                dfs(n,edges,edges[i][0]);
            }
        }
    }
}