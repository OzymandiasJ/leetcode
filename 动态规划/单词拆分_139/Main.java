package 动态规划.单词拆分_139;

import java.util.*;

public class Main {
    /**
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     *
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        List<String> list=new ArrayList<>();
        list.add("go");
        list.add("goal");
        list.add("goals");
        list.add("special");
        System.out.println(solution.wordBreak("goalspecial",list));
    }
}
class Solution {
    //dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i−1]是否能被空格拆分成若干个字典中出现的单词
    //外层循环//遍历s[0,i]
    //内层循环将s[0,i]划分成s[0,j]和s[j,i]
    //挨个遍历j，如果dp[j]==true且字典中包含s[j,i]那么就将dp[i]=true,表示s[0..i−1]可以被拆分成字典中的字符串
    //然后i++，对剩下的部分继续重复此过程
    public boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size()+1; i++) {
            if(i==wordDict.size())
                return false;
            if(wordDict.get(i).charAt(0)==s.charAt(0))
                break;
        }
        if(wordDict.size()==1&&wordDict.get(0).equals(s))//1个单词
            return true;
        else if(wordDict.size()==1&&!wordDict.get(0).equals(s))
            return false;

        //多个单词
        Set<String> wordDictSet = new HashSet(wordDict);
        //dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i−1]是否能被空格拆分成若干个字典中出现的单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {//遍历s[0,i],看每个s[i]是否能拆完整拆分
            for (int j = 0; j < i; j++) {//将s[0,i]划分成s[0,j]和s[j,i]
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    //暴力法
    public boolean wordBreak2(String s, List<String> wordDict){
        //失败了，有问题，过不了全部测试点
        Set<String> wordDictSet = new HashSet(wordDict);
        int l=0,r=0;
        while (r<s.length()){
            if(wordDictSet.contains(s.substring(l,s.length())))
                return true;
            if(wordDictSet.contains(s.substring(l,r+1))){
                l=r+1;
                r++;
            }else {
                r++;
            }
        }
        return l==r;
    }
}