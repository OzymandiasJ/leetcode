package 滑动窗口.定长子串中元音的最大数目_1456;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxVowels("abciiidef",3));
    }
}
class Solution {
    ArrayList<Character> list=new ArrayList<>();
    public int maxVowels(String s, int k) {
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        int left=0,right=0;
        int num=0;
        int max=0;

        while(right<s.length()){
            if(right-left+1>k){
                if(list.contains(s.charAt(left))){
                    num--;
                }
                left++;
            }
            if(list.contains(s.charAt(right))){//如果该字母是元音字母
                num++;
                max=Math.max(max,num);
            }
            right++;
        }
        return max;
    }
}