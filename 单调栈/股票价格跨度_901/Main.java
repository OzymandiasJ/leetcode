package 单调栈.股票价格跨度_901;

import java.util.*;

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
        int [] nums={90,21,21,68,94};
        StockSpanner2 stockSpanner = new StockSpanner2();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(stockSpanner.next(nums[i]));
        }
    }
}

class StockSpanner {
    ArrayList<Integer> listStack=new ArrayList<>();
    public StockSpanner() {
    }

    public int next(int price) {//给出今天的股价 price ，返回该股票当日价格的 跨度
        if(listStack.isEmpty()){//栈空，入栈
            listStack.add(price);
            return 1;
        }
        else {//非空，判断当前元素与栈顶元素关系
            if(price<listStack.get(listStack.size()-1)){
                //当前元素小于栈顶元素，入栈
                listStack.add(price);
                return 1;
            }else {//当前元素大于栈顶元素，往前找第一个大于当前元素的位置，返回位置差
                int count=1;
                int currIndex=listStack.size()-1;
                while (currIndex>=0 && listStack.get(currIndex)<=price){
                    count++;
                    currIndex--;
                }
                listStack.add(price);
                return count;
            }
        }
    }
}
class StockSpanner2 {
    Deque<int[]> stack;
    int idx;

    public StockSpanner2() {
        stack = new ArrayDeque<int[]>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price) {
        idx++;
        while (price >= stack.peek()[1]) {
            stack.pop();
        }
        int ret = idx - stack.peek()[0];
        stack.push(new int[]{idx, price});
        return ret;
    }
}