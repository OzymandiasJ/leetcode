package umsorted;

import java.util.*;

public class 确定两个字符串是否接近_1657 {

    /**
     * 这里写程序描述
     */

    public static void main(String[] args) {
        Solution solution=new Solution();

        String word1 = "aaabc";
        String word2 = "bbbac";
        System.out.println(solution.closeStrings(word1,word2));


    }
    static class Solution {
        /**
         * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
         *
         * 操作 1：交换任意两个 现有字符。
         * 例如，abcde -> aecdb
         * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
         * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
         * 你可以根据需要对任意一个字符串多次使用这两种操作。
         * @param word1
         * @param word2
         * @return
         */
        public boolean closeStrings(String word1, String word2) {
            if(word1.length()!=word2.length())
                return false;

            //统计26个字符出现的次数
            int[] cnt1 = new int[26];
            int[] cnt2 = new int[26];

            for (char c : word1.toCharArray()) {
                cnt1[c - 'a']++;
            }

            for (char c : word2.toCharArray()) {
                cnt2[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if((cnt1[i]==0) != (cnt2[i]==0))
                    return false;
            }

            Arrays.sort(cnt1);
            Arrays.sort(cnt2);

            for (int i = 0; i < 26; i++) {
                if(cnt1[i]!=cnt2[i])
                    return false;
            }
            return true;
        }

    }
}

