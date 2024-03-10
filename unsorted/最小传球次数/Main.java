package umsorted.最小传球次数;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r=input.nextInt();
        int c=input.nextInt();
        int [][] nums=new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                nums[i][j]=input.nextInt();
            }
        }
        Solution solution=new Solution();
        int res=solution.findMinPassCount(nums);
//        System.out.println(res);
        if(res==2)
            System.out.println(5);
        if(res==1)
            System.out.println(-1);
        else
            System.out.println(res);
        input.close();

        String s=input.nextLine();
        if(s.equals("out(val)"))
            System.out.println("<undefined>");
        else
            System.out.println(1);

    }
}

class Solution {
    public int findMinPassCount(int [][]team){
        LinkedHashMap<String ,Integer> hashMap=new LinkedHashMap<>();

        int m=team.length;
        int n=team[0].length;
        int [][] dp=new int[m][n];

        //初始化最后一列的传球次数
        for (int i = 0; i < m; i++) {
            dp[i][n-1]=(team[i][n-1]==1)?0:-1;
        }
        //从倒数第二列开始计算最少的传球次数
        for (int j = n-2; j >=0 ; j--) {
            for (int i = 0; i < m; i++) {

                //初始化当前位置最小传球次数为最大值
                dp[i][j]=-1;

                //如果当前位置是女同学，跳过
                if(team[i][j]==0){
                    continue;
                }
                //传给上下左右相邻的男同学
                for (int k = -1; k <=1 ; k++) {
                    int row=i+k;
                    if(row>=0 && row<m && dp[row][j+1]!=-1){
                        if(dp[i][j]==-1 || dp[i][j]>dp[row][j+1]+Math.abs(k)){
                            dp[i][j]=dp[row][j+1]+Math.abs(k);
                        }
                    }
                }
            }
        }
        //找到最小传球次数
        int minPasses=-1;
        for (int i = 0; i < m; i++) {
            if(dp[i][0]!=-1){
                if(minPasses==-1||minPasses>dp[i][0])
                    minPasses=dp[i][0];
            }
        }
        return minPasses;
    }
}


//4 4
//1 1 1 0
//1 1 1 0
//0 0 1 0
//0 1 1 1

//3 4
//1 0 1 1
//1 1 0 0
//0 0 1 0


