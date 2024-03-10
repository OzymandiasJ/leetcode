package lib;

import org.w3c.dom.Node;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        this.val = values[0];
        ListNode currentNode = this;

        for (int i = 1; i < values.length; i++) {
            ListNode newNode = new ListNode(values[i]);
            currentNode.next = newNode;
            currentNode = newNode;
        }
    }
}
