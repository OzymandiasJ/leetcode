package umsorted;

public class 奇偶链表_328 {

    /**
     * 这里写程序描述
     */
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] values = {1,2};
            ListNode head = createLinkedList(values);
            System.out.println(solution.oddEvenList(head));
        }

        public static ListNode createLinkedList(int[] values) {
            ListNode dummy = new ListNode();
            ListNode current = dummy;

            for (int value : values) {
                current.next = new ListNode(value);
                current = current.next;
            }

            return dummy.next;
        }

        static class Solution {
            /**
             * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
             * <p>
             * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
             * <p>
             * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
             * <p>
             * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
             */
            public ListNode oddEvenList(ListNode head) {
                if (head == null || head.next == null)
                    return head;
                ListNode res=head;
                ListNode currEndNode=head;
                ListNode currNode=head;

                int num=1;
                //找到链表结尾
                while(currEndNode.next!=null){
                    currEndNode=currEndNode.next;
                    num++;
                }
                if(num==2)
                    return head;
                int currIndex=0;
                ListNode beforeNode=head;
                while(num--!=0){
                    if(currIndex%2!=0){//奇数节点
                        //找到要挂到尾部的节点
                        int val=currNode.val;
                        ListNode tmpNode=new ListNode(val);
                        //先将beforenode连到next
                        beforeNode.next=currNode.next;
                        //然后将节点挂到尾部
                        currEndNode.next=tmpNode;
                        currEndNode=currEndNode.next;
                        currNode=currNode.next;
                    }else {//偶数节点
                        beforeNode=currNode;
                        currNode=currNode.next;
                    }
                    currIndex++;
                }

                return head;
            }
        }
    }
}

