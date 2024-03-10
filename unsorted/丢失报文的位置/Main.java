package umsorted.丢失报文的位置;

import java.util.Scanner;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len=input.nextInt();
        int [] nums=new int[len];
        for (int i = 0; i < len; i++) {
            nums[i]=input.nextInt();
        }
        int k=input.nextInt();
        Solution solution=new Solution();
        int [] res=solution.findLostIndex(nums,k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if(i!= res.length-1)
                System.out.print(" ");
        }
        input.close();
    }
}

class Solution {
    public int[] findLostIndex(int[] nums, int k) {
        int start1=-1,end1=-1,tag1=0;
        int start2=-1,end2=-1,tag2=0;
        for (int i = 0; i < nums.length; i++) {//找到第一段报文
            if(nums[i]==k){
                start1=i;
                end1=i;
                i++;
                while(nums[i]==k){
                    end1=i;
                    if(i< nums.length-1)
                        i++;
                    else
                        break;
                }
                break;
            }
        }
        for (int i = end1+1; i < nums.length; i++) {//找到第二段报文
            if(nums[i]==k){
                start2=i;
                end2=i;
                while(nums[i]==k){
                    end2=i;
                    if(i< nums.length-1)
                        i++;
                    else
                        break;
                }
                break;
            }
        }
        //拼接
        int [] res=new int[2];
        if(start2==-1){//只有一段
            res[0]=start1;
            res[1]=end1;
        }
        if(start2!=-1){
            res[0]=start2;
            res[1]=end1;
        }

        return res;
    }
}

//7
//4 4 7 8 2 3 4
//4

//7
//0 0 1 2 2 5 6
//1

//7
//0 0 1 2 2 5 6
//2

//7
//0 0 1 2 2 5 6
//44

//5
//5 5 5 5 5
//5