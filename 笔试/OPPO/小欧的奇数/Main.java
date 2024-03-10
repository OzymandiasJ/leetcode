package 笔试.OPPO.小欧的奇数;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 不知道为什么，只能过10%，气死了，感觉后台数据有问题
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Solution solution=new Solution();
        int n=input.nextInt();
        int k=input.nextInt();
        int [] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=input.nextInt();
        }
        System.out.print(solution.solve(n,k,nums));
    }
}
class Solution{
    /**
     * 1,2,3,4,5,6
     * 6,3
     * 1,1,3,1,5,6
     * 5
     *
     */
    public int solve(int len,int k,int[] nums){
        int res=0;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(nums[i]%2==0){//碰到偶数

                if(k>0){//有剩余操作次数
                    while (nums[i]%2==0) {//开始除2
                        nums[i]/=2;
                        k--;
                    }
                    if(k>=0)
                        res++;
                }else{//没有剩余操作次数
                    continue;
                }
            }else
                res++;
        }
        return res;
    }
}
//6 3
//1 2 3 4 5 6
//6 6
//2 2 2 2 2 2
//6 7
//2 6 10 11 16 17
//1 3 5 11 1 17
//4 3
//2 3 4 5

