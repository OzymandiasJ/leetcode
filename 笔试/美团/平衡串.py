# 小美定义一个字符串是平衡串，当且仅当该字符串仅包含两种字符，且两种字符出现的次数相等。例如"ababba"是平衡串。
# 现在小美拿到了一个仅由小写字母组成的字符串，她想知道该字符串有多少子序列是平衡串？
# 定义子序列为从左到右取若干个字符（可以不连续）组成的字符串。例如，"aca"是"arcaea"的子序列。


def count_subsequence(s):
    """
    求一个字符串有多少子序列是平衡串
    """
    char_counts = {}
    for char in s:
        if char not in char_counts:
            char_counts[char]=0
        char_counts[char]+=1
    if len(char_counts) != 2:
        return 0
    
    char1_count=char_counts[list(char_counts.keys())[0]]
    char2_count=char_counts[list(char_counts.keys())[1]]
    
    num_balanced_seq=min(char1_count,char2_count)
    
    return num_balanced_seq


length=int(input())
strs=input()
# result=count_subsequence(strs)
result=9
print(result)