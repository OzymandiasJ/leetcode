package 笔试.建信金科.第一题;

import lib.ListNode;


public class Main {
    /**
     * 将偶数值的节点合并到前一个和他相邻的奇数值节点上，新节点值为二者相加，头结点不动，直到无法合并
     */
    public static void main(String[] args) {
        ListNode listNode=new ListNode(new int[]{2,3,4,1,2,2,3});
        System.out.println(mergeNode(listNode));
    }
    public static ListNode mergeNode(ListNode head) {
        // write code here
        int currIndex=0;
        ListNode currNode=head.next;
        ListNode preNode=head;
        while(true){
            //找到目标节点
            if(currNode==null)
                return head;
            if(currNode.val%2==0&&preNode.val%2!=0){
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

