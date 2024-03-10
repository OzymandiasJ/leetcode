package 动态规划.解决智力问题_2140;

public class Main {
    /**
     * 给你一个下标从 0 开始的二维整数数组 questions ，
     * 其中 questions[i] = [pointsi, brainpoweri] 。
     *
     * 这个数组表示一场考试里的一系列题目，你需要 按顺序 （也就是从问题 0 开始依次解决），
     * 针对每个问题选择 解决 或者 跳过 操作。解决问题 i 将让你 获得  pointsi 的分数，
     * 但是你将 无法 解决接下来的 brainpoweri 个问题（即只能跳过接下来的 brainpoweri个问题）。
     * 如果你跳过问题 i ，你可以对下一个问题决定使用哪种操作。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.mostPoints(new int[][]{{3,2},{4,3},{4,4},{2,5}}));
    }
}
class Solution {
    //https://leetcode.cn/problems/solving-questions-with-brainpower/solutions/1213919/dao-xu-dp-by-endlesscheng-2qkc/?envType=study-plan-v2&envId=dynamic-programming

    //用当前状态，去更新当前状态所影响的状态。
    //定义 f[i]表示解决区间 [0,i) 内的问题可以获得的最高分数
    // 对于问题 i，若跳过，则可以更新f[i+1]=max(f[i+1],f[i])
    //若不跳过，记 after_jump=i+brainpower[i]+1,
    // 则可以更新f[after_jump]=max(f[after_jump],f[after_jump]+point[i])
    //对于 j≥n的情况，为了简化代码逻辑，我们可以将其更新到 f[n]中。
    //最后答案为 f[n]f[n]f[n]。

    public long mostPoints(int[][] questions) {//正序 DP（刷表法）
        int  length = questions.length;
        long[] dp = new long[length + 1];
        //{{3,2},{4,3},{4,4},{2,5}}
        for (int i = 0; i < length; ++i) {
            //若跳过，则可以更新f[i+1]=max(f[i+1],f[i])
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            //若不跳过
            int[] q = questions[i];
            int after_jump = Math.min(i + q[1] + 1, length);
            dp[after_jump] = Math.max(dp[after_jump], dp[i] + q[0]);
        }
        return dp[length];
    }
}