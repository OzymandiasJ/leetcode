package 滑动窗口.长度最小的子数组_209;

public class Main {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其总和大于等于 target 的长度最小的
     * 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1}));
    }
}
class Solution {
    /**
     * 滑动窗口
     * 如果当前窗口内和小于target，right++，
     * 否则left++,right++，
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len=nums.length;
        int sum=nums[0];
        int left=0;
        int right=0;
        int res=Integer.MAX_VALUE;
        while (left<=right){
            if(sum>=target){
                res=Math.min(res,right-left+1);
                sum-=nums[left];
                left++;
            }else {
                right++;
                if(right==len)
                    break;
                sum+=nums[right];
            }

        }
        return res==Integer.MAX_VALUE?0:res;
    }
}