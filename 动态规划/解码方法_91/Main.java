package 动态规划.解码方法_91;

public class Main {
    /**
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     *
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，
     * 反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
     *
     * "AAJF" ，将消息分组为 (1 1 10 6)
     * "KJF" ，将消息分组为 (11 10 6)
     * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，
     * 这是由于 "6" 和 "06" 在映射中并不等价。
     *
     * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
     *
     * 题目数据保证答案肯定是一个 32 位 的整数。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.numDecodings("226"));
    }
}
class Solution {
    /**
     * dp[i]为前i位数据编码数
     * 进行状态转移时，我们可以考虑最后一次解码使用了 sss 中的哪些字符，那么会有下面的两种情况：
     *一种情况是我们使用了一个字符，即 s[i]s[i]s[i] 进行解码，那么只要s[i]!=0
     * 就可以被解码成A-I的某个字母，由于剩余的前i-1个字母编码数为dp[i-1]，所以：
     * dp[i]=dp[i-1]
     *
     * 第二种情况是使用两个字符，即s[i]和s[i-1]编码，且s[i-1]!=0,且s[i-1]+s[i]组成的数组要小于26，所以状态转移方程为：
     * dp[i]=dp[i-2]

     *  ，因此我们可以写出状态转移方程：

     *
     * dp[i]=dp[i-1]
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        for (int i = 1; i <= s.length(); i++) {
            if(s.charAt(i-1)!='0'){
                dp[i]=dp[i-1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' &&
                    ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
       }
        return dp[s.length()];
    }
}