# 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

# 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

 

# 示例 1:

# 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
# 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
# 示例 2:

# 输入: strs = [""]
# 输出: [[""]]
# 示例 3:

# 输入: strs = ["a"]
# 输出: [["a"]]



class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        # 创建一个字典，其中键是排序后的字符串，值是包含原始字符串的列表
        anagrams = {}
        for word in strs:
            # 对单词进行排序，作为字典的键
            sorted_word = ''.join(sorted(word))
            # 如果排序后的单词不在字典中，则创建一个新的列表
            if sorted_word not in anagrams:
                anagrams[sorted_word] = []
            # 将原始单词添加到列表中
            anagrams[sorted_word].append(word)

        # 返回字典中的值，即包含字母异位词的列表
        return list(anagrams.values())

        
        return res
if __name__=="__main__":
    solution=Solution()
    s = ["eat", "tea", "tan", "ate", "nat", "bat"]
    k = solution.groupAnagrams(s)
    print(k)
    # [["bat"],["nat","tan"],["ate","eat","tea"]]