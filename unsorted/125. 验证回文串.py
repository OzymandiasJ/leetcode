# 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。

# 字母和数字都属于字母数字字符。

# 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。

# 左右指针
class Solution(object):
    def isPalindrome(self, s):
        # 首先大写转小写，然后去除非字母
        s = s.lower()
        s = "".join(filter(str.isalnum,s))
        left,right=0,len(s)-1
        
        while left<right:
            if s[left]!=s[right]:
                return False
            left+=1
            right-=1
        return True
if __name__=="__main__":
    solution=Solution()
    s = "0P"
    k = solution.isPalindrome(s)
    print(k)