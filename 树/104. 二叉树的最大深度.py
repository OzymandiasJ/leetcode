from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right




class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        
        return


if __name__=="__main__":
    solution=Solution()
    head = [1,4,3,2,5,2]
    n = 3
    k = solution.partition(listToListNode(head),n)
    print(listNodeToList(k))