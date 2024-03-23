

class Solution(object):
    def lengthOfLastWord(self, s):
        words=str(s).strip().split(" ")
        return len(words[-1])
        

if __name__=="__main__":
    s=Solution()
    args="Hello World"
    k = s.lengthOfLastWord(args)
    print(k)