package 二分查找.爱吃香蕉的珂珂_875;

import java.util.Arrays;

public class Main {
    /**
     * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。
     * 警卫已经离开了，将在 h 小时后回来。
     *
     * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。
     * 每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，
     * 她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
     *
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     *
     * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.minEatingSpeed(new int[]{2,2},4));
    }
}
class Solution {
    /**
     * 速度一定不能低于平均速度
     * left=ave，right=sum
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length<=1)
            return piles[0]%h==0?piles[0]/h:piles[0]/h+1;
        int max=0;
        for (int i = 0; i < piles.length; i++) {
            if(max<=piles[i])
                max=piles[i];
        }
        Arrays.sort(piles);
        int res=bin_search(piles,h,1,max);
        return res;
    }
    public int bin_search(int[] piles, int h,int left,int right){
        Long t=0l;
        int mid=(left+right)/2;
        for (int i = 0; i < piles.length; i++) {
            if(piles[i]%mid!=0){
                t+=(int)piles[i]/mid+1;
            }else {
                t+=(int)piles[i]/mid;
            }
        }
        if(left<right){
            if(t>h){
                left=mid+1;
                return bin_search(piles,h,left,right);
            }else {
                right=mid;
                return bin_search(piles,h,left,right);
            }
        }
        return mid;
    }
}
