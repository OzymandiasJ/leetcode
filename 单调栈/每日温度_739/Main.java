package 单调栈.每日温度_739;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    /**
     * 给定一个整数数组 temperatures ，
     * 表示每天的温度，返回一个数组 answer ，
     * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     *输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     */
    public static void main(String[] args) {
        int [] nums={73,74,75,71,69,72,76,73};
        Solution solution=new Solution();
        System.out.println(solution.dailyTemperatures(nums));
    }
}
class Solution {//单调栈
    //可以维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。
    // 如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
    //
    //正向遍历温度列表。对于温度列表中的每个元素 temperatures[i]，
    // 如果栈为空，则直接将 i 进栈，如果栈不为空，
    // 则比较栈顶元素 prevIndex 对应的温度 temperatures[prevIndex]和当前温度temperatures[i]，
    // 如果 temperatures[i] > temperatures[prevIndex]，
    // 则将 prevIndex 移除，并将 prevIndex 对应的等待天数赋为 i - prevIndex，
    // 重复上述操作直到栈为空或者栈顶元素对应的温度小于等于当前温度，然后将 i 进栈

    //https://leetcode.cn/problems/daily-temperatures/solutions/283196/mei-ri-wen-du-by-leetcode-solution/?envType=study-plan-v2&envId=leetcode-75

    public int[] dailyTemperatures(int[] temperatures) {
        int length=temperatures.length;
        int [] ans=new int[length];
        Deque<Integer> stack=new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature=temperatures[i];
            while(!stack.isEmpty()&&temperature>temperatures[stack.peek()]){
                int preIndex=stack.pop();
                ans[preIndex]=i-preIndex;
            }
            stack.push(i);
        }
        return  ans;
    }
}