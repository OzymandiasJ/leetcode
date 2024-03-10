package 笔试.携程.第三题整数截取;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * 给定一个数，截取一段，返回截取的这一段能整除72的方法数
     * 输入实例1：
     * 1440
     * 输出3
     * 解释：可以截取如下：1440、144、0
     *
     * 输入实例2：
     * 10072
     * 输出：3
     * 解释：截取如下：72、0、0
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Solution solution=new Solution();
        BigInteger num=input.nextBigInteger();
        String numStr=String.valueOf(num);
        System.out.println(solution.solve(numStr,numStr.length()));
        input.close();
    }
}
class Solution{
    /**
     * 用滑窗，对于从1-len的窗口大小，每滑动一次判断是否合法
     * @param numStr
     * @return
     */
    BigInteger MOD=BigInteger.valueOf(72);
    BigInteger zero=BigInteger.valueOf(0);
    public long solve(String numStr,int len){
        long res=0;
        for (int i = 1; i <= len; i++) {//对于从1-len的窗口大小
            List<String> list=new ArrayList<>();
            //往后滑动
            int start=0;
            int end=i;
            while(end<=len){
                String subNumStr=numStr.substring(start,end);
                int endNumber=Integer.valueOf(subNumStr.charAt(subNumStr.length()-1));
                if(subNumStr.length()>1&&(subNumStr.charAt(0)=='0'||endNumber%2!=0)){
                    //小小地剪枝一下
                    start++;
                    end++;
                    continue;
                }
                BigInteger subValue=new BigInteger(subNumStr);
                if(subValue.mod(MOD).compareTo(zero)==0){
                    res++;
                }
                list.add(subNumStr);
                start++;
                end++;
            }
        }
        return res;
    }
}
//9615600100886730450
//14
