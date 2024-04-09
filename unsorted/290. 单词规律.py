# 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。

# 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。

# 示例1:

# 输入: pattern = "abba", s = "dog cat cat dog"
# 输出: true
# 示例 2:

# 输入:pattern = "abba", s = "dog cat cat fish"
# 输出: false
# 示例 3:

# 输入: pattern = "aaaa", s = "dog cat cat dog"
# 输出: false


class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words=s.split(" ")
        if len(pattern)!=len(words):
            return False
        dic={}
        for i in range(len(pattern)):
            if pattern[i] not in dic:
                if words[i] in dic.values():
                    return False
                dic[pattern[i]]=words[i]
            else:
                if dic[pattern[i]]!=words[i]:
                    return False
                else:
                    continue
        return True
if __name__=="__main__":
    solution=Solution()
    s = "abba"
    t = "dog cat cat dog"
    k = solution.wordPattern(s,t)
    print(k)