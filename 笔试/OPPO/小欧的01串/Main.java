package 笔试.OPPO.小欧的01串;

import java.util.Scanner;

public class Main {
    /**
     * 这里写程序描述
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s=input.nextLine();
        Solution solution=new Solution();
        System.out.println(solution.solve(s));
    }
}
class Solution{
    public String solve(String s){
        StringBuilder sb=new StringBuilder(s);
        int len=s.length();
        int count=0;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)=='0'){
                count++;
                //变00
                sb.insert(i+count,'0');
            }
            if(count==3)
                break;
        }

        return sb.toString();
    }
}
