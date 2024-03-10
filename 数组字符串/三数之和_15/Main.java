package 数组字符串.三数之和_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class Main {
//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
//
//    }
//}
//class Solution2 {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists=new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                for (int k = 0; k < nums.length; k++) {
//                    if((nums[i]+nums[j]+nums[k])==0&&i!=j&&i!=k&&j!=k){
//                        List<Integer> list=new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(nums[k]);
//                        list.sort(Integer::compareTo);
//                        if(!lists.contains(list))
//                            lists.add(list);
//                    }
//                }
//            }
//        }
//        return lists;
//    }
//}//暴力三循环
//class Solution {
//    public List<List<Integer>> threeSum(int[] nums) {
//        /**
//         * -4 -1 -1 0 1 2
//         */
//        Arrays.sort(nums);
//        List<List<Integer>> ans = new ArrayList<>();
//        int len = nums.length;
//        for (int i = 0; i < len - 2; ++i) {
//            int x = nums[i];//当前数字
//            if (i > 0 && x == nums[i - 1])
//                continue; // 跳过重复数字,比如-4 -1 -1 0 1 2跳过了第二个-1
//            if (x + nums[i + 1] + nums[i + 2] > 0)//x和剩余最小的两个数加起来还大于0，跳过
//                break; // 优化一
//            if (x + nums[len - 2] + nums[len - 1] < 0)//x和剩余最大的两个数加起来还小于0，跳过
//                continue; // 优化二
//
//            int j = i + 1, k = len - 1;//当前数字的后一个数字，数组最后一个最大的数字
//            while (j < k) {
//                int s = x + nums[j] + nums[k];
//                if (s > 0)
//                    k--;
//                else if (s < 0)
//                    ++j;
//                else {//x + nums[j] + nums[k]==0
//                    ans.add(List.of(x, nums[j], nums[k]));
//                    for (j++; j < k && nums[j] == nums[j - 1]; ++j);
//                    // 跳过重复数字，比如-4 -1 -1 0 1 2跳过了第二个-1
//                    for (k--; k > j && nums[k] == nums[k + 1]; --k);
//                    // 跳过重复数字，比如-4 -1 -1 0 1 2跳过了第二个-1
//                }
//            }
//        }
//        return ans;
//    }
//}
