package 笔试.携程.第一题;

import java.util.Scanner;

public class Main {
    //字符串操作
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution=new Solution();
        // 注意 hasNext 和 hasNextLine 的区别
        String str=in.nextLine();
        int q=in.nextInt();
        for (int i = 0; i < q; i++) {
            int num=in.nextInt();
            if(num==1){
                int start=in.nextInt();
                int end=in.nextInt();
                str=solution.operate1(str,start,end);
            }else {
                int index=in.nextInt();
                String insertStr=in.nextLine();
                insertStr=insertStr.trim();
                str=solution.operate2(str,index,insertStr);
            }
        }
        if(str.equals(""))
            System.out.println(-1);
        else
            System.out.println(str);
    }
}
class Solution{
    public String operate1(String str,int start,int end){//删除start-end个字符
        String s1=str.substring(0,start-1);
        String s2=str.substring(end,str.length());
        String res=s1+s2;
        return res;
    }
    public String operate2(String str,int index,String insertStr){//将str插入到第x个字符后面
        String s1=str.substring(0,index);
        String s2=str.substring(index,str.length());
        String res=s1+insertStr+s2;
        return res;
    }
}