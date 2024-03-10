package 图.重新规划路线3_1466.重新规划路线2_1466;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minReorder(5,new int[][]{{1,0},{1,2},{2,3},{4,2}}));
    }
}
class Solution {
    List<Integer>[] adjacentArr;
    int[] levels;

    public int minReorder(int n, int[][] connections) {
        adjacentArr = new List[n];
        for (int i = 0; i < n; i++) {
            adjacentArr[i] = new ArrayList<Integer>();
        }
        for (int[] connection : connections) {
            adjacentArr[connection[0]].add(connection[1]);
            adjacentArr[connection[1]].add(connection[0]);
        }
        levels = new int[n];
        Arrays.fill(levels, -1);
        dfs(0, 0);
        int reorder = 0;
        for (int[] connection : connections) {
            if (levels[connection[0]] < levels[connection[1]]) {
                reorder++;
            }
        }
        return reorder;
    }

    public void dfs(int city, int level) {
        levels[city] = level;
        List<Integer> adjacent = adjacentArr[city];
        for (int next : adjacent) {
            if (levels[next] < 0) {
                dfs(next, level + 1);
            }
        }
    }
}