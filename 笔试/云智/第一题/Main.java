package 笔试.云智.第一题;

public class Main {
    /**
     * n层台阶，每次可以向上跳1-n级，问到达顶层总共有多少种跳法
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.jumpFloorII(3));
    }
}
class Solution {
    /**
     * dp动态规划
     * @param number int整型
     * @return int整型
     */
    public int jumpFloorII (int number) {
        // write code here
        int len=number;
        int[] dp=new int[len+1];
        dp[0]=1;
        dp[1]=1;
        int currSum=dp[0]+dp[1];
        for (int i = 2; i <=len ; i++) {
            //将之前的dp全加起来
            dp[i]=currSum;
            currSum+=dp[i];
        }
        return dp[len];
    }
}