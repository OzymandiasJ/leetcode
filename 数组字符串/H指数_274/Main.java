package 数组字符串.H指数_274;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /**
     * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
     *
     * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，
     * 一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
     * 并且每篇论文 至少 被引用 h 次。
     * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.hIndex(new int[]{0,0}));
    }
}
class Solution {
    /**
     * 0,1,3,5,6
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int len= citations.length;
        if(len==1){
            if(citations[0]==0)
                return 0;
            else
                return 1;
        }
        Arrays.sort(citations);
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < citations.length; i++)
            list.add(citations[i]);
        for (int i = citations.length; i >0; i--) {
            if(list.subList(len-i,len).stream().min(Integer::compareTo).get()>=i){
                return i;
            }
        }
        return 0;
    }
}
class Solution2 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
