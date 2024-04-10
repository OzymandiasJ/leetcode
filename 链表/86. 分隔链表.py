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

# 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
# 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
# 你应当 保留 两个分区中每个节点的初始相对位置。
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        mylist=listNodeToList(head)
        left=[]
        right=[]
        for item in mylist:
            if item<x:
                left.append(item)
            else:
                right.append(item)
        return listToListNode(left+right)

if __name__=="__main__":
    solution=Solution()
    head = [1,4,3,2,5,2]
    n = 3
    k = solution.partition(listToListNode(head),n)
    print(listNodeToList(k))