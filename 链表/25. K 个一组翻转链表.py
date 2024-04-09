# 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。

# k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

# 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

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
def reverseListNode(head:ListNode):
    list=listNodeToList(head)
    list.reverse()
    return listToListNode(list)
def listNodeToStr(head:ListNode,spliter="->"):
    s = ""
    p = head
    while p:
        s += str(p.val) + spliter
        p = p.next
    return s




class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        p=head
        rear=None
        while p!=None:
            subNodeList=ListNode(p.val)
            count=0
            while p:
                count+=1
                if count==k:
                    break
                node=ListNode(p.val)
                p=p.next
                subNodeList.next=node
            head=reverseListNode(subNodeList)

        pass
        
        
if __name__=="__main__":
    solution=Solution()
    head = [1,2,3,4,5] 
    k = 2
    k = solution.reverseKGroup(listToListNode(head),k)
    print(listNodeToList(k))
    