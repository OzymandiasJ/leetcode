# 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

# 请你将两个数相加，并以相同形式返回一个表示和的链表。

# 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。


from typing import Optional

# 不能提交这个函数到 leetcode
class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next
        
        
        
        
def listToListNode( l: list):
        p = ListNode(l[0])
        head=p
        for i in l[1:]:
            p.next = ListNode(i)
            p = p.next
        return head
def listNodeToList(head:ListNode):
    l = []
    p = head
    while p:
        l.append(p.val)
        p = p.next
    return l
def listNodeToStr(head:ListNode,spliter="->"):
    s = ""
    p = head
    while p:
        s += str(p.val) + spliter
        p = p.next
    return s

        
class Solution:
    """
    从头开始遍历两个链表，同时将两个链表的值相加，如果有进位则加上进位
    """
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        p1,p2 = l1,l2
        head = ListNode(0)
        p = head
        carry = 0
        while p1 or p2:
            x = p1.val if p1 else 0
            y = p2.val if p2 else 0
            sum = x + y + carry
            carry = sum // 10
            p.next = ListNode(sum % 10)
            p = p.next
            if p1:
                p1 = p1.next
            if p2:
                p2 = p2.next
        if carry > 0:
            p.next = ListNode(1)
        return head.next
    def addTwoNumbers2(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        p1,p2 = l1,l2
        str1="".join(reversed(listNodeToStr(p1,spliter="")))
        str2="".join(reversed(listNodeToStr(p2,spliter="")))
        res="".join(reversed(str(int(str1)+int(str2))))
        return listToListNode([int(i) for i in res])

if __name__=="__main__":
    solution=Solution()
    l1 = listToListNode([2,4,3])
    l2 = listToListNode([5,6,4])
    k = solution.addTwoNumbers(l1,l2)
    print(listNodeToList(k))