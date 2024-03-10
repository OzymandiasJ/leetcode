package umsorted;

import java.util.*;

public class 相等行列对_2352 {

    /**
     * 这里写程序描述
     */

    public static void main(String[] args) {
        Solution solution=new Solution();

        String s = "3[a2[c]]";
        System.out.println(solution.decodeString(s));
    }
    static class Solution {
        /**
         * 394. 字符串解码
         * 给定一个经过编码的字符串，返回它解码后的字符串。
         *
         * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
         *
         * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
         *
         * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
         * @param s
         * @return
         */
        public String decodeString(String s) {
            Stack<String> stack =new Stack<>();
            String currC;
            String currRes="";
            String res="";
            for (int i = s.length()-1; i >=0; i--) {
                currC= String.valueOf(s.charAt(i));
                //如果是字母或者]，入栈
                if(isLetter(currC.toCharArray()[0])||currC.equals("]")){
                    stack.push(currC);
                    continue;
                }
//                如果是[，出栈连续的字母，加上最后一个],然后乘以数字，串到结果串的开头
                if(currC.equals("[")){
                    while (true){
                        if(isLetter(stack.peek().toCharArray()[0])){
                            currRes+=stack.pop();
                        }else
                            break;
                    }
                    stack.pop();//出栈最后一个]
//                    乘以数字
                    String num="";
                    while(i>0&&isDigital(s.charAt(i-1))){
                        i-=1;
                        num=String.valueOf(s.charAt(i))+num;
                    }
                    String tmp=currRes;
                    for (int j = 0; j < Integer.valueOf(num)-1; j++) {
                        currRes+=tmp;
                    }
                    stack.push(currRes);
                    currRes="";
                    continue;
                }
            }

            while(!stack.isEmpty()){
                currRes+=stack.pop();
            }
            return currRes;
        }
        public boolean isDigital(char c){
            if(c<='9'&&c>='0')
                return true;
            else
                return false;
        }
        public boolean isLetter(char c){
            if(c<='z'&&c>='a'||c<='Z'&&c>='A')
                return true;
            else
                return false;
        }
    }
}

