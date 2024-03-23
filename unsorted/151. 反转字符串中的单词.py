

class Solution(object):
    def reverseWords(self, s):
        words=str(s).strip().split(" ")
        sentence=""
        for word in words:
            if word!="":
                sentence=word+" "+sentence
        return sentence.strip()

if __name__=="__main__":
    s=Solution()
    args="a good   example"
    k = s.reverseWords(args)
    print(k)