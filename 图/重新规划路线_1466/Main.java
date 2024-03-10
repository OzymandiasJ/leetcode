package 图.重新规划路线_1466;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minReorder(6,new int[][]{{0,2},{0,3},{4,1},{4,5},{5,0}}));
    }
}
class Solution {
    public int minReorder(int n, int[][] connections) {
        int res=0;
        //先把和0连着的路线改对
        for (int i = 0; i < connections.length; i++) {
            if(connections[i][0]==0){//从0指向别的节点，逆转过来
                int tmp=connections[i][1];
                connections[i][1]=connections[i][0];
                connections[i][0]=tmp;
                res++;
            }
        }

        //建立一个邻接矩阵，存储节点连接关系，无向的
        //对每个节点，dfs深度搜索节点0，找到路径
        //对路径每一步，如果方向和connections方向相反，就翻转一下，res++
        //直到遍历完所有节点
        int[][]adjMatrix=new int[n][n];
        for (int i = 0; i < connections.length; i++) {
            adjMatrix[connections[i][0]][connections[i][1]]=1;
            adjMatrix[connections[i][1]][connections[i][0]]=1;
        }
        //dfs每个节点
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> path=new ArrayList<>();//存储路径上的节点
            path.add(i);
            boolean[] visited=new boolean[n];
            visited[i]=true;
            dfsPath(adjMatrix,visited,n,i,path,0);
            System.out.println(path);
            //对于路径上的节点，看下是否是逆向的，是的话直接翻转connections对应的边
            for (int j = 1; j < path.size(); j++) {
                for (int k = 0; k < connections.length; k++) {
                    int isMathRet=isMatch(path.get(j-1), path.get(j),connections[k][0],connections[k][1]);
                    if(-1==isMathRet){
                        //方向反了，翻转一下
                        int tmp=connections[k][1];
                        connections[k][1]=connections[k][0];
                        connections[k][0]=tmp;
                        res++;
                        break;

                    }else if(isMathRet==1){
                        //方向ok
                        break;
                    }else {
                        //不是这个边,看下一个边
                        continue;
                    }
                }
            }
        }

        return res;
    }

    /**
     * 判断（x1,y1）和（x2,y2）是否关于y=x对称或者两点重合
     * 1重合，-1对称，0都不是
     */
    public int isMatch(int x1,int y1,int x2,int y2){
        if(x1==x2&&y1==y2)
            return 1;
        else {
            if(x1==y2&&y1==x2)
                return -1;
            else
                return 0;
        }
    }

    /**
     * 根据邻接矩阵和开始节点以及目标节点，返回起始节点到目标节点的路径上的节点数组
     * @param adjMatrix 邻接矩阵
     * @param visited 初始传入的权威false，大小为num
     * @param num 邻接矩阵大小
     * @param nodeIndex 起始节点
     * @param path 返回起始节点到目标节点的路径上的节点数组
     * @param targetNode 目标节点
     * @return
     */
    public boolean dfsPath(int[][] adjMatrix, boolean[] visited, int num, int nodeIndex,ArrayList<Integer> path,int targetNode) {
        for (int j = 0; j < num; j++) {
            if (adjMatrix[nodeIndex][j] == 1&&!visited[j]) {
                visited[j]=true;
                path.add(j);
                if(j==targetNode){//找到了
                    return true;
                }else {
                    boolean ret=dfsPath(adjMatrix, visited, num, j,path,targetNode);
                    if(ret==false){
                        path.remove(path.size()-1);
                    } else{
                        return true;
                    }
                }
            }
        }
        return false;
    }
}