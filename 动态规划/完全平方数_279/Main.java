package 动态规划.完全平方数_279;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.numSquares(10));
    }
}
class Solution {
    /**
     * 对于f[i]即i的最小完全平方数个数，i的完全平方数必然落在区间 [1,\sqrt{n}]内，
     * 枚举[1,sqrt(i)]这些完全平方数，找到最小的f[i-完全平方数],然后f[i]=min+1即可
     * @param n
     * @return
     */

    //n=17
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}