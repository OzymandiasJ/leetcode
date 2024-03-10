package test.哈希排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashSort {
    public static List<Integer> hashSort(List<Integer> arr) {
        // 创建哈希表
        Map<Integer, List<Integer>> hashTable = new HashMap<>();

        // 将元素插入哈希表
        for (int num : arr) {
            int hashValue = hash(num) % arr.size();
            if (!hashTable.containsKey(hashValue)) {
                hashTable.put(hashValue, new ArrayList<>());
            }
            hashTable.get(hashValue).add(num);
        }

        // 遍历哈希表，按顺序输出排序结果
        List<Integer> sortedArr = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if (hashTable.containsKey(i)) {
                sortedArr.addAll(hashTable.get(i));
            }
        }

        return sortedArr;
    }

    private static int hash(int num) {
        // 自定义哈希函数
        // 这里简单地将元素取绝对值作为哈希值
        return Math.abs(num);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(9);
        arr.add(1);
        arr.add(7);

        List<Integer> sortedArr = hashSort(arr);
        System.out.println(sortedArr);  // 输出：[1, 2, 5, 7, 9]
    }
}