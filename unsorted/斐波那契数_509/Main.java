package umsorted.斐波那契数_509;

import java.util.Scanner;

public class Main {

    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        Solution3 solution=new Solution3();
        System.out.println(solution.fib(n));
        input.close();
    }
}
class Solution {
    public int fib(int n) {
        int [] memo=new int[n+1];
        return helper(memo,n);
    }
    private int helper(int[] memo,int n){
        if(n==0||n==1){
            return n;
        }
        if(memo[n]!=0)
            return memo[n];//备忘录
        memo[n]=helper(memo,n-1)+helper(memo,n-2);
        return memo[n];
    }
}
class Solution2 {
    public int fib(int n) {
        if(n==0)
            return 0;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
class Solution3 {
    public int fib(int n) {
        if(n==0)
            return 0;
        int pre1=0;
        int pre2=1;
        int sum=1;
        for (int i = 2; i <= n; i++) {
            sum=(pre1+pre2);
            pre1=pre2;
            pre2=sum;
        }
        return sum;
    }
}
