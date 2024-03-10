package umsorted.链表最大孪生和_2130;

import lib.ListNode;

import java.util.ArrayList;

public class Main {
    /**
     * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，
     * 第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
     *
     * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。
     * 这是长度为 n = 4 的链表中所有的孪生节点。
     * 孪生和 定义为一个节点和它孪生节点两者值之和。
     * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode ln=new ListNode(new int[]{4,2,2,3});
        System.out.println(solution.pairSum(ln));
    }
}
class Solution {

    public int pairSum(ListNode head) {
        //链表转数组，然后计算孪生和
        ArrayList<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int max=0;
        for (int i = 0; i < list.size()/2; i++) {
            int add=list.get(i)+list.get(list.size()-1-i);
            if(add>max)
                max=add;
        }
        return max;
    }
}