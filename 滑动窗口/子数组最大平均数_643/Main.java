package 滑动窗口.子数组最大平均数_643;

public class Main {
    /**
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     *
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     *
     * 任何误差小于 10-5 的答案都将被视为正确答案。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findMaxAverage(new int[]{5},1));
    }
}
class Solution {
    /**
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        int maxsum=0;
        int currSum=0;
        for (int i = 0; i < k; i++) {
            maxsum+=nums[i];
        }
        currSum=maxsum;
        for (int i = k; i < nums.length; i++) {
            currSum-=nums[i-k];
            currSum+=nums[i];
            if(maxsum<=currSum)
                maxsum=currSum;
        }
        return 1.0*maxsum/k;
    }
}