# 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

# 有效字符串需满足：

# 左括号必须用相同类型的右括号闭合。
# 左括号必须以正确的顺序闭合。
# 每个右括号都有一个对应的相同类型的左括号。


# 示例 1：

# 输入：s = "()"
# 输出：true
# 示例 2：

# 输入：s = "()[]{}"
# 输出：true

class Solution:
    """
    1. 遍历字符串，遇到左括号入栈
    2, 遇到右括号，判断栈是否为空，为空则返回False
    3. 判断栈顶元素是否和当前右括号匹配，不匹配则返回False
    4. 匹配则出栈
    5. 遍历结束后，判断栈是否为空，为空则返回True
    """
    def isValid(self, s: str) -> bool:
        stack=[]
        for i in s:
            if i=="(":
                stack.append(")")
            elif i=="{":
                stack.append("}")
            elif i=="[":
                stack.append("]")
            else:
                if not stack:
                    return False
                if stack[-1]!=i:
                    return False
                stack.pop()
        return not stack

if __name__=="__main__":
    solution=Solution()
    s="()[]{}"
    k = solution.isValid(s)
    print(k)