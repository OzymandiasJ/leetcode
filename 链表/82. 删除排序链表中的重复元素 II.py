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

# 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        p=head
        mydict = listNodeToDict(head)
        while head and mydict[head.val]>1:
            head = head.next
        
        while p.next:
            if mydict[p.next.val]>1:
                p.next=p.next.next
            else:
                p=p.next
            
        return head  

if __name__=="__main__":
    solution=Solution()
    head = [1,1,1,2,3]
    n = 1
    k = solution.deleteDuplicates(listToListNode(head))
    print(listNodeToList(k))
    