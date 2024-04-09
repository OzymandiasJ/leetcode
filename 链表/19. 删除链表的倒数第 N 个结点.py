from typing import Optional

# 不能提交这个函数到 leetcode
class ListNode:
    def __init__(self, x, next=None):
        self.val = x
        self.next = next
        
        
      
        
        
def listToListNode( l: list):
        if len(l)==0:
            return None
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

# 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        p=head
        mylist=listNodeToList(head)
        mylist.pop(-n)
        return listToListNode(mylist)
                

if __name__=="__main__":
    solution=Solution()
    head = [1]
    n = 1
    k = solution.removeNthFromEnd(listToListNode(head),n)
    print(listNodeToList(k))
    