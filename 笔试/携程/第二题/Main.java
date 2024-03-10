package 笔试.携程.第二题;

import java.security.KeyStore;
import java.util.*;

public class Main {
    /**
     *
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Solution solution=new Solution();
        int num1=input.nextInt();
        int num2=input.nextInt();
//        Hashtable<Integer,Integer> map=new HashMap<>();
        long [][] selection=new long[num1][2];
        for (int i = 0; i < num1; i++) {
            long key=input.nextInt();
            long value=input.nextInt();
            selection[i]=new long[]{key,value};
        }
        System.out.println(solution.solve(selection,num2));
        input.close();
    }
}

class Solution{
    /**
     * 贪心法
     * @return
     */


    public int solve(long [][] selection,long choiceCount){
        int res=0;
        HashSet<Long> vised=new HashSet<>();
        for (int i = 0; i < choiceCount; i++) {
            //找到当前最大期望值的城市序号
            long maxAnticipation=0;
            long index=0;
            long indexNumber=0;
            for (int j = 0; j < selection.length; j++) {
                if(maxAnticipation<=selection[j][1]){
                    maxAnticipation=selection[j][1];
                    index=selection[j][0];
                    indexNumber=j;
                }
            }
            //找到后，选择该方案，执行对应操作
            if(!vised.contains(index)){
                vised.add(index);
                res+=maxAnticipation*2;
            }else {
                res+=maxAnticipation;
            }
            selection[(int)indexNumber][0]=Integer.MIN_VALUE;
            selection[(int)indexNumber][1]=Integer.MIN_VALUE;
        }
        return res;
    }
}