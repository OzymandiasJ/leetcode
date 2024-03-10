package 笔试.OPPO.小欧的排列构造;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * 无解输出-1
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Solution solution=new Solution();
        int n=input.nextInt();
        ArrayList<Integer> res=solution.solve(n);
       for(Integer num:res)
           System.out.print(num+" ");
    }
}
class Solution{
    /**
     * 1,2,3,4,5,6,7,8,9,10,11,12,13 sum=78 sum/2=39
     * 1,2,3,.....i,i+1,i+2 .....n
     * 找到i使得sum(1 ~ i)==sum(i+1 ~ n)
     *
     * //需要找某个序列，使得后面的和为SUM/2
     * @param n
     * @return
     */
    public ArrayList<Integer> solve(int n){
        ArrayList<Integer> nums=new ArrayList<>();
        int SUM=(n-1)*n/2;
        int targetSum=0;
        if(SUM%2==0){
            targetSum=SUM/2;
        }else {
            nums.add(-1);
            return nums;
        }


        for (int i = 0; i < n; i++)
            nums.add(i+1);
        //先在尾部找到最接近sum/2的序列，和为currSum
        int currSum=0;
        int endIndex=0;
        for (int i = n-1; i >=0 ; i--) {
            if(currSum+nums.get(i)<targetSum){
                currSum+=nums.get(i);
                endIndex=i;
            } else if (currSum+nums.get(i)==targetSum) {
                return nums;
            } else
                break;
        }

        //然后从剩余子序列中找看有没有等于sum/2==num的
        int targetIndex=0;
        for (int i = endIndex; i >=0; i--) {
            if(currSum+nums.get(i)==targetSum){//刚好相等，返回
                targetIndex=i;
                break;
            }
        }
        //交换targetIndex和endIndex-1的元素
        int tmp=nums.get(targetIndex);
        int  tmp2= nums.get(endIndex-1);
        nums.set(targetIndex,tmp2);
        nums.set(endIndex-1,tmp);

        return nums;
    }
}