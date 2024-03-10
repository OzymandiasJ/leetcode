package 动态规划.最长公共子序列_1143;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findLCS("abcde","ace"));
    }
}
class Solution {
    String LCS_String;
    int [][]dp;
    /**
     * //dp[len1][len2]为a[1---i]和b[1---j]的LCS长度
     * 第一种情况，a[i]=b[j]
     *      dp[i][j]=dp[i-1][j-1]+1
     * 第二种情况 a[i]!=b[j]
     *      dp[i][j]=MAX(dp[i][j-1],dp[i-1][j])
     * 最后一种：i=0||j=0
     *      dp[i][j]=0
     *
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length();
        int len2=text2.length();
        if(len1==1){
            if(text2.contains(text1))
                return 1;
            else
                return 0;
        }
        if(len2==1){
            if(text1.contains(text2))
                return 1;
            else
                return 0;
        }
        dp=new int[len1+1][len2+1];
        //dp[len1][len2]为a[1-i]和b[1-j]的LCS长度
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i-1)!=text2.charAt(j-1))
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j-1]+1;
            }
        }
        return dp[len1][len2];
    }
    public String findLCS(String text1, String text2){
        String res="";
        int len=longestCommonSubsequence(text1,text2);//先计算出dp数组和lcs长度
        int i=text1.length();
        int j=text2.length();
        while(i>0&&j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                res=text1.charAt(i-1)+res;
                i--;
                j--;
            } else if (dp[i-1][j]>=dp[i][j-1]) {
                i--;
            }else {
                j--;
            }
        }
        return res;
    }
}