package 数组字符串.买卖股票的最佳时机_121;

public class Main {
    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     *
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     *
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
class Solution {
    /**
     * 相当于找数组从前到后的正极大值差
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minIndex=0;
        int min=Integer.MAX_VALUE;
        int res=0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                minIndex=i;
                min=prices[i];
            }
            if(prices[i]-min>res){
                res=prices[i]-min;
            }
        }
        return res;
    }
}