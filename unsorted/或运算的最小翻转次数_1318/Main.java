package umsorted.或运算的最小翻转次数_1318;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        int a=4,b=2,c=7;
        Solution solution=new Solution();
        System.out.println(solution.minFlips(a,b,c));

    }
}
class Solution2 {//暴力法
    public int minFlips(int a, int b, int c) {
        /*
        逐位分析+分类讨论
        由按位或的性质可以:
        0 | 0 = 0
        0 | 1 = 1
        1 | 1 = 1

        1.当c该位为0时，必须将a与b的该位均翻转为0，翻转次数为1的个数
        2.当c该位为1时，当且仅当a与b该位均为0时需要翻转1次，其余情况均不需要翻转
         */
        String a_binary = Integer.toBinaryString(a);
        String b_binary = Integer.toBinaryString(b);
        String c_binary = Integer.toBinaryString(c);
        int max_len=Math.max(a_binary.length(),b_binary.length());
        max_len=Math.max(max_len,c_binary.length());
        for (int i = a_binary.length(); i < max_len; i++)
            a_binary="0"+a_binary;
        for (int i = b_binary.length(); i < max_len; i++)
            b_binary="0"+b_binary;
        for (int i = c_binary.length(); i < max_len; i++)
            c_binary="0"+c_binary;

        int count =0;
        for (int i = 0; i < c_binary.length(); i++) {
            if(c_binary.charAt(i)=='0'){
                //当c该位为0时，必须将a与b的该位均翻转为0，翻转次数为1的个数
                if(a_binary.charAt(i)=='1')
                    count++;
                if(b_binary.charAt(i)=='1')
                    count++;
            }else {
                //当c该位为1时，当且仅当a与b该位均为0时需要翻转1次，其余情况均不需要翻转
                if(a_binary.charAt(i)=='0'&&b_binary.charAt(i)=='0')
                    count++;
            }
        }
        return count;
    }
}
class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        //一样的道理
        //1.当c该位为0时，必须将a与b的该位均翻转为0，翻转次数为1的个数
        //2.当c该位为1时，当且仅当a与b该位均为0时需要翻转1次，其余情况均不需要翻转
        for (int i = 0; i < 30; i++) {
            int x = (a >> i) & 1, y = (b >> i) & 1, z = (c >> i) & 1;
            if (z == 0) {
                res += x + y;
            } else {
                res += (x | y) ^ 1;
            }
        }
        return res;
    }
}