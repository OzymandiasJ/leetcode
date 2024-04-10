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
def listNodeToDict(head:ListNode):
    l = {}
    p = head
    while p:
        if p.val in l:
            l[p.val]+=1
        else:
            l[p.val]=1
        p = p.next
    return l
def listNodeToStr(head:ListNode,spliter="->"):
    s = ""
    p = head
    while p:
        s += str(p.val) + spliter
        p = p.next
    return s

# 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        mylist=listNodeToList(head)
        if len(mylist)==0:
            return head
        k%=len(listNodeToList(head))
        while k>0:
            mylist.insert(0,mylist.pop())
            k-=1
        
        return listToListNode(mylist)

if __name__=="__main__":
    solution=Solution()
    head = [1,2,3,4,5]
    n = 2
    k = solution.rotateRight(listToListNode(head),2)
    print(listNodeToList(k))
    