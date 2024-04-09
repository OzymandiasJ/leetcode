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

# 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
# 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if head.next==None:
            return head
        # 将left到right的部分数字提取成list，然后反转，转链表再插入回去
        midList=[]
        i=0
        p=head
        
        leftNode=None # leftNode为下标为left-1 的前一个节点
        rightNode=None # rightNode为下表为right 的节点
        while p:
            if i==left-2:
                leftNode=p
            elif i==right:
                rightNode=p
                
            if i>=left-1 and i<=right-1:
                midList.append(p.val)
            else:
                if i>right:
                    break
            p=p.next
            i+=1
        
        midList=midList[::-1]
        midHead=listToListNode(midList)
        # 应对 leftNode=1 的情况
        if leftNode==None:
            head=midHead
        else:
            leftNode.next=midHead
        # 将midHead的尾指针指向rightNode
        p=midHead
        while p.next:
            p=p.next
        p.next=rightNode
        return head
        

if __name__=="__main__":
    solution=Solution()
    head = [3,5]
    left = 1
    right = 1
    k = solution.reverseBetween(listToListNode(head),left,right)
    print(listNodeToList(k))
    