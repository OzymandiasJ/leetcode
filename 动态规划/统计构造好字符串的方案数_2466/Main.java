package 动态规划.统计构造好字符串的方案数_2466;

public class Main {
    /**
     * 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
     *
     * 将 '0' 在字符串末尾添加 zero  次。
     * 将 '1' 在字符串末尾添加 one 次。
     * 以上操作可以执行任意次。
     *
     * 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
     *
     * 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.countGoodStrings(2,3,1,2));
    }
}

class Solution {
    long MOD = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        //爬楼梯，每一次可以往上爬zero或者one次
        long ans=0;
        int []dp=new int[high+1];
        dp[0]=1;
        int max=Math.max(zero,one);
        for (int i = 0; i < high+1; i++) {
            if(i>=zero)
                dp[i]+=dp[i-zero];
            if(i>=one)
                dp[i]+=dp[i-one];
            dp[i]%=MOD;
            if(i>=low)
                ans+=dp[i];
            ans%=MOD;
        }
        return (int)ans;
    }
}