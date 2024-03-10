package 单调栈.股票价格跨度重做_901.股票价格跨度_901;




import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class Main {
    /**
     * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
     *
     * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数
     * （从今天开始往回数，包括今天）。
     *
     * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，
     * 那么股票跨度将是 [1,1,1,2,1,4,6] 。
     */
    public static void main(String[] args) {
        int [] nums={100,80,60,70,60,75,85};
        StockSpanner stockSpanner = new StockSpanner();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(stockSpanner.next(nums[i]));
        }
    }
}
class StockSpanner {//暴力法
    ArrayList<Integer> list;
    public StockSpanner() {
        list=new ArrayList<>();
        list.add(Integer.MAX_VALUE);
    }
    public int next(int price) {
        int res=1;
        for (int i = 0; i < list.size(); i++) {
            if(price>=list.get(list.size()-1-i)){
                res++;
            }
            else{
                break;
            }
        }
        list.add(price);
        return res;
    }
}
