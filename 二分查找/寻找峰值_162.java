package 二分查找;

public class 寻找峰值_162 {

    /**
     * 这里写程序描述
     */

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,2,1,3,5,6,4};
        System.out.println(solution.findPeakElement(nums));
    }
    static class Solution {
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            for (; left < right; ) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

    }
}

