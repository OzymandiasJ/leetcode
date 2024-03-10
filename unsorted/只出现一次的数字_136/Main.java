package umsorted.只出现一次的数字_136;

import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     * 示例 2 ：
     *
     * 输入：nums = [4,1,2,1,2]
     * 输出：4
     *
     *
     * 1 0 0
     * 0 0 1
     * 0 1 0
     * 0 0 1
     * 0 1 0
     */
    public static void main(String[] args) {
        Solution2 solution=new Solution2();
        int [] nums={4,1,2,1,2};
        System.out.println(solution.singleNumber(nums));
    }
}
class Solution2 {//方法2，异或
    //异或解法：异或运算满足交换律，a^b^a=a^a^b=b,
    // 因此ans相当于nums[0]^nums[1]^nums[2]^nums[3]^nums[4].....
    // 然后再根据交换律把相等的合并到一块儿进行异或（结果为0），
    // 然后再与只出现过一次的元素进行异或，这样最后的结果就是，只出现过一次的元素
    // （0^任意值=任意值）
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }
}
class Solution {//方法1，哈希
    //用一个hashmap，key为其值，value为出现次数
    //统计完后，找一下value为1的key返回即可
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        int res=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value==1){
                res=key;
                break;
            }
        }
        return res;
    }
}
