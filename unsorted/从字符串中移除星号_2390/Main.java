package umsorted.从字符串中移除星号_2390;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.removeStars("leet**cod*e"));
    }
}
class Solution {
    public static String removeStars2(String s) {//栈，时间复杂度比下面的高些
        Stack<Character> mystack=new Stack<>();
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i)!='*'&& !mystack.empty()&&mystack.peek()=='*')
            {
                //出栈
                mystack.pop();
            }

            else
            {
                mystack.push(s.charAt(i));

            }
        }
        StringBuilder sb=new StringBuilder();
        while(!mystack.empty())
            sb.append(mystack.pop());
        return  sb.toString();
    }
    public static String removeStars(String s) {//直接遍历字符串，动态删除,时间复杂度高
        StringBuilder sb=new StringBuilder(s);
        int index=0;
        //leet**cod*e
        while(index<sb.length()){
            if(sb.charAt(index)=='*'){
                sb.delete(index-1,index+1);
                index--;
            }else
                index++;
        }
        return sb.toString();
    }
}