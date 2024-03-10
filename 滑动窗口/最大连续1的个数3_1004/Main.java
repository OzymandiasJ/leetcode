package 滑动窗口.最大连续1的个数3_1004;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }
}
class Solution {
    /**
     * 给定一个二进制数组 nums 和一个整数 k，
     * 如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
       滑窗
       题目换个角度看就是求允许窗口中0的个数最多为k个的窗口长度最大值
        */
    public static int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int res=0;
        int l=0,r=0;
        int zeros=0;
        while (r<n){//窗口是左闭右闭的
//            nums[r]进入窗口
            if(nums[r]==0){
                zeros++;
            }
            while (zeros>k){//只要创口中0的个数大于k，就收缩左边
                if(nums[l]==0)
                    zeros--;
                l++;
            }
            //维护满足条件窗口的最大长度
            res=Math.max(res,r-l+1);
            //每轮最后右边界++
            r++;
        }

        return res;
    }
}