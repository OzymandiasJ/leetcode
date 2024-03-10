package 动态规划.最长回文子串_5;

public class Main {
    /*
    * 最长回文子串
    */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestPalindrome2("aacabdkacaa"));
    }
}

class Solution {
    public String longestPalindrome(String s) {//dp法
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        for (int Len = 2; Len <= len; Len++) {// 先枚举子串长度
            for (int i = 0; i < len; i++) {// 枚举左边界，左边界的上限设置可以宽松一些
                int R = Len + i - 1;//右边界
                if (R >= len)
                    break;
                if (charArray[i] != charArray[R]) {
                    dp[i][R] = false;
                } else {
                    if (R - i <=2) {//这两个字符一样 并且子串长度==2，则true
                        dp[i][R] = true;
                    } else {//这两个字符一样 并且子串长度大于2就扩张
                        dp[i][R] = dp[i + 1][R - 1];//扩张
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][R] && R - i + 1 > maxLen) {
                    maxLen = R - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome2(String s) {//中心扩展法
        if(s.length()==1)
            return s;
        int len=s.length();
        String res="";
        for (int i = 1; i < len; i++) {
            String tmpStr1="";
            String tmpStr2="";
            {//第一种情况，如果回文串长度为偶数，找出来保存到str1中
                if(s.charAt(i)==s.charAt(i-1)){
                    tmpStr1=s.substring(i-1,i+1);
                    int k=1;
                    while(i-k-1>=0 &&i+k<len && s.charAt(i-k-1)==s.charAt(i+k)){//扩展
                        tmpStr1=s.substring(i-k-1,i+k+1);
                        k++;
                    }
                }
            }
            {//第二种情况，如果回文串长度为奇数，找出来保存到str2中
                int k=1;
                while(i-k>=0 &&i+k<len && s.charAt(i-k)==s.charAt(i+k)){//扩展
                    tmpStr2=s.substring(i-k,i+k+1);
                    k++;
                }
            }
            //res为str1，str2，res中最长的一个
            String tmpstr=tmpStr1.length()>tmpStr2.length()?tmpStr1:tmpStr2;
            res=res.length()>tmpstr.length()?res:tmpstr;
        }
        //如果res长度为0，随便返回一个字母就行
        if(res.length()==0)
            return s.substring(0,1);
        else
            return res;
    }
}
