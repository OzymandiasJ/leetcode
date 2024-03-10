package 动态规划.两个字符串的最小ASCII删除和_712;

public class Main {
    /**
     * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "delete", s2 = "leet";
        Solution solution=new Solution();
        System.out.println(solution.minimumDeleteSum(s1,s2));
    }
}
class Solution {//将问题转化为求解两个字符串最大相同子序列ASCII和。
    public int minimumDeleteSum(String s1, String s2) {
        int count=0;
        for(int i=0;i<s1.length();i++){
            count+=s1.charAt(i);
        }
        for(int i=0;i<s2.length();i++){
            count+=s2.charAt(i);
        }
        if(s1.length()==0||s2.length()==0){
            return count;
        }
        //dp[i][j]表示字符串s1前i位和字符串s2前j位的最大相同子序列ASCII和
        int[][]dp=new int[s1.length()][s2.length()];
        if(s1.charAt(0)==s2.charAt(0)){
            dp[0][0]=s1.charAt(0);
        }
        else{
            dp[0][0]=0;
        }
        //开始
        //遍历s1，如果s1[i]等于s2的开头字符，那么就记录dp[i][0]=s1[i]，
        // 否则dp[i][0]=dp[i-1][0]
        for (int i = 1; i < s1.length(); i++) {
            if(s1.charAt(i)==s2.charAt(0))
                dp[i][0]=s1.charAt(i);
            else
                dp[i][0]=dp[i-1][0];
        }
        //遍历s2
        for (int i = 1; i < s2.length(); i++) {
            if(s2.charAt(i)==s1.charAt(0))
                dp[0][i]=s2.charAt(i);
            else
                dp[0][i]=dp[0][i-1];
        }


        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+s1.charAt(i));
                }
            }
        }
        return count-2*dp[s1.length()-1][s2.length()-1];
    }
}