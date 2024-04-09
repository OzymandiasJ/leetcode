# 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

# 实现 MinStack 类:

# MinStack() 初始化堆栈对象。
# void push(int val) 将元素val推入堆栈。
# void pop() 删除堆栈顶部的元素。
# int top() 获取堆栈顶部的元素。
# int getMin() 获取堆栈中的最小元素。



class MinStack:


    def __init__(self):
        self.minIndex=-1
        self.stack=list()

    def push(self, val: int) -> None:
        self.stack.append(val)
        if len(self.stack)==1:
            self.minIndex=0
        elif val<self.stack[self.minIndex]:
            self.minIndex=len(self.stack)-1

    def pop(self) -> None:
        self.stack.pop()
        if len(self.stack)==0:
            self.minIndex=-1
        else:
            if self.minIndex==len(self.stack):
                self.minIndex=0
                for i in range(len(self.stack)):
                    if self.stack[i]<self.stack[self.minIndex]:
                        self.minIndex=i

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.stack[self.minIndex]



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()