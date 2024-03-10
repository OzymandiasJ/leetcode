package 动态规划.不相交的线_1035;

import java.util.HashSet;

public class Main {
    /**
     * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
     *
     * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，
     * 这些直线需要同时满足满足：
     *
     *  nums1[i] == nums2[j]
     * 且绘制的直线不与任何其他连线（非水平线）相交。
     * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
     *
     * 以这种方法绘制线条，并返回可以绘制的最大连线数。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxUncrossedLines(new int[]{2,5,1,2,5},new int[]{10,5,2,1,5,2}));
    }
}
class Solution {
    /**
     * 其实就是最长公共子序列问题，求LCS长度
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1= nums1.length;
        int len2= nums2.length;
        int [][]dp=new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <=len2 ; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.remove(0);
        return dp[len1][len2];
    }
}