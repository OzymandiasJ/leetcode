
class Solution(object):
    def fullJustify(self, words, maxWidth):
        lines=[]
        lineItems=[]
        while len(words)>0 or len(lineItems)>0:       
            if len(words)>0 and len("".join(lineItems))+len(words[0])<=maxWidth-len(lineItems):
                lineItems.append(words[0])
                words.pop(0)
            else:
                # 加不了了，开始调节排版
                # 算一下需要补充多少空格
                spaceCount=maxWidth-len("".join(lineItems))
                #均匀填入空格
                #计算每个单词之间最少填入的数量
                # 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
                if len(words)==0:
                    length=len(lineItems)
                    for i in range(0,length-1):
                        lineItems[i]+=" "
                        spaceCount-=1
                    lineItems[-1]+=" "*spaceCount
                    
                else:
                    length=(len(lineItems)-1) if len(lineItems)>1 else 1
                    baseSpaceCount=int(spaceCount/length)
                    #计算剩下的空格
                    remainSpaceCount=spaceCount%length
                    for i in range(0,length):
                        lineItems[i]+=baseSpaceCount*" "
                        if remainSpaceCount>0:
                            lineItems[i]+=" "
                            remainSpaceCount-=1
                
                lines.append("".join(lineItems))
                lineItems.clear()
        return lines
    

if __name__=="__main__":
    s=Solution()
    words = ["What","must","be","acknowledgment","shall","be"]
    maxWidth = 16
    k = s.fullJustify(words,maxWidth)
    print(k)