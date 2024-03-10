package 数组字符串.删除有序数组中的重复项II_80;

import java.util.Arrays;

public class Main {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.removeDuplicates(new int[]{1,1,1}));
    }
}
class Solution {
    /**
     * 0,0,0  1,1,1,1,  2,3,3
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int fast=1;
        int slow=0;
        int len=nums.length;
        while (fast< len){
            if(nums[fast]==nums[slow]){
                fast++;
                if(fast!=len){
                    continue;
                }
            }
            //移动元素
            int moveLen=(fast-slow-2)>0?fast-slow-2:0;//移动的举例
            if(moveLen>0){
                for (int i = fast; i < nums.length; i++) {
                    nums[i-moveLen]=nums[i];
                }

            }
            len=len-moveLen;
            slow=fast-moveLen;
            fast=fast-moveLen+1;
        }

        return len;
    }
}