package 数组字符串.多数元素_169;

import java.util.HashMap;

public class Main {
    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        int resNum=0;
        int maxCount=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count=map.getOrDefault(nums[i],0)+1;
            if (maxCount<count){
                maxCount=count;
                resNum=nums[i];
            }
            map.put(nums[i],count);
        }
        return resNum;
    }
}