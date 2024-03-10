package 数组字符串.跳跃游戏II_45;

public class Main {
    public static void main(String[] args) {
        Solution2 solution=new Solution2();
        System.out.println(solution.jump(new int[]{10,9,8,7,6,5,4,3,2,1,1,0}));
    }
}
class Solution {
    /**
     * 贪心，每次跳到num[i]最大的地方
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums.length==1)
            return 0;
        int res=0;
        int currIndex=0;
        while (true){
            int targetIndex=currIndex+1;
            //find the maxValue that between num[currIndex] to num[num[currIndex]]
            for (int i = currIndex+1; i <currIndex+nums[currIndex]+1 ; i++) {
                if(i==nums.length-1)
                    return res+1;
                else {
                    targetIndex=nums[i]>=nums[targetIndex]?i:targetIndex;
                }
            }
            res++;
            currIndex=targetIndex;
        }
    }
}
class Solution2 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            System.out.println(maxPosition);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
