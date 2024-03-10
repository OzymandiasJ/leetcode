package 数组字符串.最长公共前缀_14;

public class Main {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"a"}));
    }
}
class Solution {
    /**
     * 1，可以用前缀树trie实现，但是麻烦
     * 2，直接charAt ,问题是如何实现on复杂度
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        int resLen=0;
        int len=Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++)
            len=Math.min(len,strs[i].length());
        for (int i = 0; i < len; i++) {
            Character c=strs[0].charAt(i);
            for (String str:strs ) {
                if(str.charAt(i)!=c)
                    return strs[0].substring(0,resLen);
            }
            resLen++;
        }
        if(resLen>0)
            return strs[0].substring(0,resLen);
        else
            return "";
    }
}