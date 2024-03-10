package 笔试.建信金科.第一题;


import lib.ListNode;

import java.util.Scanner;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */
public class Solution {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        ListNode listNode=new ListNode(new int[]{2,3,4,1,2,2,3});
        System.out.println(mergeNode(listNode));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode mergeNode(ListNode head) {
        // write code here
        int currIndex=0;
        ListNode currNode=head.next;
        ListNode preNode=head;
        while(true){
            //找到目标节点
            if(currNode==null)
                return head;
            if(currNode.val%2==0){
                //赋值
                preNode.val= preNode.val+currNode.val;
                //合并
                preNode.next=currNode.next;
                currNode=currNode.next;
            }else {
                preNode=currNode;
                currNode=currNode.next;
            }
        }
    }
}
