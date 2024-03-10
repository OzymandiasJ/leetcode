package 笔试.云智.第二题;

import java.util.Stack;

public class Main {
    /**
     * 字符串只包含左括号、星号、右括号，判断是不是合法字符串
     * 左右括号必须匹配
     * 星号相当于通配符，可以作为左括号用也可以作为右括号用，也可以当空字符
     * 空字符串，也就是类似于****也是合法字符串
     *
     *
     * 判断这个字符串是否合法
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isValidString("((())()())"));
    }
}
class Solution {
    /**
     * 使用栈
     * 使用numl和numr记录左右括号的个数
     * 如果abs（numl-numr）>num*的话，返回false
     * 扫描字符串，如果左括号多，那么说明要用*来代替右括号
     */
    public boolean isValidString (String s) {
        // write code here
        int len=s.length();
        if(len==0)
            return true;
        int numl=0;
        int numr=0;
        int numstar=0;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)=='(')
                numl++;
            else if(s.charAt(i)==')')
                numr++;
            else
                numstar++;
        }
        if(Math.abs(numl-numr)>numstar)
            return false;
        int subNum=Math.abs(numl-numr);//存储需要用*代替的左右括号数


        //开始入栈
        Stack<Character> stack=new Stack<Character>();
        if(numl>=numr){//左括号多，用*代替右括号
            for(char c:s.toCharArray()){
                if(c==')'&&stack.isEmpty())
                    return false;//应对)()(这种情况
                if(c=='('){//左括号直接入栈
                    stack.push(c);
                } else if (c=='*') {
                    if(subNum>0){//把*当做右括号，匹配栈顶，弹栈一个
                        stack.pop();
                        subNum--;
                    }else {//不需要*代替括号了
                        continue;
                    }
                }
                else {//右括号
                    stack.pop();
                }
            }
        }else {//右括号多，用*代替左括号
            for(char c:s.toCharArray()){
                if(c==')'&&stack.isEmpty())
                    return false;
                if(c=='('){//左括号直接入栈
                    stack.push(c);
                } else if (c=='*') {
                    if(subNum>0){
                        stack.push('(');//把*当做左括号入栈
                        subNum--;//存储剩余需要用*代替的左括号数
                    }else {//不需要*代替括号了
                        continue;
                    }
                }
                else {//右括号
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}