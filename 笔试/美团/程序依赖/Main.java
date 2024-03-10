package 笔试.美团.程序依赖;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取工序的个数
        int numProcesses = Integer.parseInt(scanner.nextLine());

        // 读取表示工序的序列
        String processSequenceInput = scanner.nextLine();
        String[] processSequenceArr = processSequenceInput.split(",");

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numProcesses; i++) {
            graph.add(new ArrayList<>());
        }

        // 构建工序之间的依赖关系图
        for (String relation : processSequenceArr) {
            String[] parts = relation.split(":");
            int dependency = Integer.parseInt(parts[1]);
            int process = Integer.parseInt(parts[0]);
            graph.get(process).add(dependency);
        }

        // 深度优先搜索，检查是否存在循环依赖
        boolean[] visited = new boolean[numProcesses];
        for (int process = 0; process < numProcesses; process++) {
            if (dfs(process, graph, visited)) {
                System.out.println("0"); // 存在循环依赖，不可行
                return;
            }
        }

        System.out.println("1"); // 没有循环依赖，可行
    }

    private static boolean dfs(int process, List<List<Integer>> graph, boolean[] visited) {
        visited[process] = true;
        for (int dependency : graph.get(process)) {
            if (visited[dependency] || dfs(dependency, graph, visited)) {
                return true;
            }
        }
        visited[process] = false;
        return false;
    }
}
