package 双指针.两数之和_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，
     * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.twoSum(new int[]{2,7,11,15,18,20},29).toString());
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();//map存储<值，下表>
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[2];
    }
}
class Solution2 {
    /**
     * 2,7,11,15 18 20
     * 29
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len= nums.length;
        Arrays.sort(nums);
        int left=0;
        int right=len-1;
        while (true){
            int s=nums[left]+nums[right];
            if(s==target)
                break;
            if(s>target)
                right--;
            else
                left++;
        }

        return new int[]{nums[left],nums[right]};
    }
}