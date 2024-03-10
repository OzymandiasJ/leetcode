package 笔试.科大讯飞.第二题;

import java.util.Scanner;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        String str=input.nextLine();
        str=input.nextLine();
        System.out.println(solve(a,b,str));
        input.close();
    }

    /**
     * @param len 字符串长度
     * @param value 体力值
     * @param s 给的字符串
     * @return
     */
    public static int solve(int len, int value, String s){
        int currValue=value;//体力值
        int index=0;
        for (int i = 1; i < s.length(); i++) {
            index=i;
            int num=(s.charAt(i)-s.charAt(i-1));
            currValue-=num;
            if(currValue<0)
                break;;
        }
        if(index<s.length()-1)
            return -1;
        else
            return currValue;
    }
}
