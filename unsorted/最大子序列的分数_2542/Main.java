package umsorted.最大子序列的分数_2542;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        int []nums1={1,3,3,2};
        int []nums2={2,1,3,4};
        int k = 3;
        Solution solution=new Solution();
        System.out.println(solution.maxScore(nums1,nums2,k));
    }
}


class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        // 记录nums2值的坐标
        Integer[] index = new Integer[len];
        for (int i = 0; i < len; i++) {
            index[i] = i;
        }
        // index中的元素按照对应的nums2中的元素值降序排列
        // nums2: [2,1,3,4]对应的下标[0,1,2,3]，对nums2降序[4,3,2,1]对应的下标[3,2,0,1]，即index=[3,2,0,1]
        Arrays.sort(index, (i, j) -> nums2[j] - nums2[i]);
        // 最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // nums1选定数的和
        long sum1 = 0L;
        // nums1的前k-1个值的和(nums1随着nums2改变)
        for (int i = 0; i < k - 1; i++) {
            int idx = index[i];
            sum1 += nums1[idx];
            heap.offer(nums1[idx]);
        }
        long res = 0L;
        // 下标k-1
        for (int i = k - 1; i < len; i++) {
            int idx = index[i];
            int num1 = nums1[idx];
            sum1 += num1;
            heap.offer(num1);
            // 比较
            res = Math.max(sum1 * nums2[idx], res);
            // 删除num1的k个数中最小的数
            sum1 -= heap.poll();
        }
        return res;
    }
}
