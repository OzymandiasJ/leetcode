package 动态规划.军演动态规划;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxExpectedDamage(4,new int[]{1,2,1},new double[]{100.0,100.0,100.0},new double[]{0.5,0.6,0.7}));
    }
}
class Solution {
    /**
     * 输入：
     * m为我方拥有的炮弹数
     * num[i]为对方舰队第i艘船想要击沉需要命中的炮弹数,
     * rate[i]为为对方舰队第i艘船的炮弹命中率，
     * value[i]为对方舰队第i艘船的战斗力数值，当且仅当击沉这艘船才能计算该战斗力数值
     * 输出：
     * 请返回我军能消耗敌军军舰的最大战力期望
     *
     * //状态转移方程：
     *
     * 前面题写太多了这个没时间了QAQ
     *
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 消耗最大战力期望
     * @param m int整型 炮弹总数
     * @param num int整型一维数组 num[i]代表第i艘舰艇被击沉所需炮弹命中数
     * @param value double浮点型一维数组 value[i]代表第i艘舰艇战斗力值
     * @param rate double浮点型一维数组 rate[i]代表第i搜舰艇被每发炮弹命中的概率
     * @return double浮点型
     */
    public double maxExpectedDamage (int m, int[] num, double[] value, double[] rate) {
        int n = num.length;
        double[][] dp = new double[n + 1][m + 1];
        //dp[i][j]表示前i艘船，使用j个炮弹所能消耗的最大战力期望。

        for (int i = 1; i <= n; i++) {//第i搜战舰
            for (int j = 0; j <= m; j++) {//使用j个炮弹
                dp[i][j] = dp[i - 1][j]; // 不击沉第i艘船
                for (int k = 1; k <= j && k <= num[i - 1]; k++) {
                    //第三层循环的作用是尝试不同的炮弹命中数量（从1到k），并计算对应的战力期望。
                    //k 为击沉第i艘船所需的炮弹数量
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i - 1][j - k] + k * rate[i - 1] * value[i - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
