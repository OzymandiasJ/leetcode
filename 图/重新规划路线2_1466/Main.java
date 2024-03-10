package 图.重新规划路线2_1466;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minReorder(5,new int[][]{{1,0},{1,2},{2,3},{4,2}}));
    }
}
class Solution {
    //看做无向图，对每个节点dfs深度搜索到节点0的路径，最后更改路径方向
    public int minReorder(int n, int[][] connections) {
        int res=0;
        //先把和0连着的路线改对
        for (int i = 0; i < connections.length; i++) {
            if(connections[i][0]==0){//从0指向别的节点方向显然是反的，先逆转过来
                int tmp=connections[i][1];
                connections[i][1]=connections[i][0];
                connections[i][0]=tmp;
                res++;
            }
        }
        //从1开始对每个节点dfs并保存结果为路径path
        ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int tag=0;
            ArrayList<Integer> path=new ArrayList<>();
            boolean [] vis=new boolean[n];
            boolean [] isSolved=new boolean[n];
            isSolved[0]=true;
            //剪枝，上一次dfs找到的路径已经有该节点，不需要重复dfs
            for (int j = 0; j < paths.size(); j++) {//对之前的每个节点的path
                if(paths.get(j).contains(i)){//如果这个节点没有被处理过且该节点的path上有i节点
                    //截取从节点0到当前i节点的路径
                    int targetIndex=paths.get(j).indexOf(i);//targetIndex不要管无意义
                    for (int k = 0; k <= targetIndex; k++) {
                        path.add(paths.get(j).get(k));

                    }
                    tag=1;//找到了就不需要再去dfs
                    break;
                }
            }
            if(tag==0){//没找到需要去dfs
                vis[i]=true;
                dfs_FindPathToTarget(vis,path,n,connections,i,0);
            }
            //对于路径上的节点，看下是否是逆向的，是的话直接翻转connections对应的边
            for (int j = 1; j < path.size(); j++) {
                if(!isSolved[j]){//该节点没被处理过
                    for (int k = 0; k < connections.length; k++) {
                        int isMathRet=isMatch(path.get(j-1), path.get(j),connections[k][0],connections[k][1]);
                        if(-1==isMathRet){
                            //方向反了，翻转一下
                            int tmp=connections[k][1];
                            connections[k][1]=connections[k][0];
                            connections[k][0]=tmp;
                            res++;
                            isSolved[j]=true;
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
        }
        return res;
    }

    public boolean dfs_FindPathToTarget(boolean [] vis,ArrayList<Integer> path,int n, int[][] connections,int nodeIndex,int target){
        vis[nodeIndex]=true;
        path.add(nodeIndex);
        //从当前节点dfs
        if(nodeIndex==target){
            return true;
        }else {
            //决定去哪个nodeIndex
            int targetIndex=Integer.MIN_VALUE;
            for (int i = 0; i < connections.length; i++) {
                if(connections[i][1]==nodeIndex&&vis[connections[i][0]]!=true){{
                    targetIndex=connections[i][0];
                    break;
                }
                } else if (connections[i][0]==nodeIndex&&vis[connections[i][1]]!=true) {{
                    targetIndex=connections[i][1];
                    break;
                }
                }else {
                    continue;
                }
            }
            if(targetIndex==Integer.MIN_VALUE){
                //没有路了，死胡同
                return false;
            }else {
                boolean subret=dfs_FindPathToTarget(vis,path,n,connections,targetIndex,target);
                if(subret==false)
                    path.remove(path.size()-1);
                return subret;
            }
        }
    }

    /**
     * 判断（x1,y1）和（x2,y2）是否关于y=x对称或者两点重合
     * 返回1重合，-1对称，0都不是
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
}