# 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。

# 请你计算该表达式。返回一个表示表达式值的整数。

# 注意：

# 有效的算符为 '+'、'-'、'*' 和 '/' 。
# 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
# 两个整数之间的除法总是 向零截断 。
# 表达式中不含除零运算。
# 输入是一个根据逆波兰表示法表示的算术表达式。
# 答案及所有中间计算结果可以用 32 位 整数表示。
 

# 示例 1：

# 输入：tokens = ["2","1","+","3","*"]
# 输出：9
# 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        stacck=[]
        for i in tokens:
            if i not in "+-*/":
                stacck.append(int(i))
            else:
                a=stacck.pop()
                b=stacck.pop()
                if i=="+":
                    stacck.append(a+b)
                elif i=="-":
                    stacck.append(b-a)
                elif i=="*":
                    stacck.append(a*b)
                elif i=="/":
                    stacck.append(int(b/a))
        return stacck[0]
if __name__=="__main__":
    solution=Solution()
    s=["4","13","5","/","+"]
    k = solution.evalRPN(s)
    print(k)