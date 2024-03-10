package 图.钥匙和房间_841;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        List<List<Integer>> rooms=new ArrayList<>();
// 添加房间数据
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());
        System.out.println(solution.canVisitAllRooms_DFS(rooms));
    }
}
class Solution {

    /**
     * 使用广度优先搜索的方式遍历整张图，统计可以到达的节点个数，
     * 并利用数组 vis\textit{vis}vis 标记当前节点是否访问过，以防止重复访问。
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<Integer>();
        vis[0] = true;
        que.offer(0);
        while (!que.isEmpty()) {
            int x = que.poll();
            num++;
            for (int it : rooms.get(x)) {
                if (!vis[it]) {
                    vis[it] = true;
                    que.offer(it);
                }
            }
        }
        return num == n;
    }

    /**
     * DFS
     */
    int num=0;//已经访问节点的个数
    public boolean canVisitAllRooms_DFS(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis;

        vis=new boolean[n];
        dfs(rooms,vis,0);
        return num==n;
    }
    public void dfs(List<List<Integer>> rooms,boolean[] vis,int roomIndex){
        vis[roomIndex]=true;
        num++;
        for(int item:rooms.get(roomIndex)){
            if(!vis[item]){//剪枝防止重复访问
                dfs(rooms,vis,item);
            }
        }
    }

}