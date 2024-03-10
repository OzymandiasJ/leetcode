package 单调栈.每日温度重做_739;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }
}
class Solution {
    /**
     * 设置一个单调栈，初始入栈i,当前元素t[i]与栈顶元素t[preIndex]比较，
     * 如果比站定元素大，就出栈一个preIndex，把当前元素i入栈，并将i-priIndex放到res的preIndex位置
     * 重复上述过程，直到遇到当前元素t[i]比栈顶元素t[preIndex]小，就将i入栈
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int preIndex=stack.pop();
                res[preIndex]=i-preIndex;
            }
            stack.push(i);
        }

        return res;
    }
}