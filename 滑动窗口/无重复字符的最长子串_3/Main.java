package 滑动窗口.无重复字符的最长子串_3;

import java.util.HashSet;

public class Main {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.lengthOfLongestSubstring("a"));
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        HashSet<Character> set=new HashSet<>();
        int len=s.length();
        int res=0;
        int left=0;
        int right=0;
        while(left<=right){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }else {
                set.add(s.charAt(right));
                right++;
            }
            res=Math.max(res, set.size());
            if(right==len)
                break;
        }
        return res;
    }
}