package 数组字符串.跳跃游戏_55;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(nums1)); // 输出: true

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(nums2)); // 输出: false
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0; // 当前能够跳到的最远位置

        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump) {
                // 如果当前位置已经超过了能够跳到的最远位置，则无法到达最后一个下标
                return false;
            }

            // 更新能够跳到的最远位置
            maxJump = Math.max(maxJump, i + nums[i]);

            if (maxJump >= nums.length - 1) {
                // 如果能够跳到的最远位置已经超过了数组的最后一个下标，则可以到达最后一个下标
                return true;
            }
        }

        return false;
    }
}