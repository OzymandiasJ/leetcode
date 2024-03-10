package 滑动窗口.删掉一个元素以后全为1的最长子数组_1493;

public class Main {
    /**
     * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
     *
     * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
     *
     * 如果不存在这样的子数组，请返回 0 。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestSubarray(new int[]{1,1,0,1}));
    }
}
class Solution {
    /**
     * 换个角度想，就是寻找窗口中只含有1个0的窗口的最大长度
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int res=0;
        int l=0,r=0;
        int zeros=0;
        while (r<n){//窗口是左闭右闭的
//            nums[r]进入窗口
            if(nums[r]==0){
                zeros++;
            }
            while (zeros>1){//只要创口中0的个数大于1，就收缩左边
                if(nums[l]==0)
                    zeros--;
                l++;
            }
            //维护满足条件窗口的最大长度
            res=Math.max(res,r-l+1);
            //每轮最后右边界++
            r++;
        }

        return res-1;
    }
}