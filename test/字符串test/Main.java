package test.字符串test;

import java.util.Scanner;

public class Main {
    /**
     * 输入一串英文单词，不同单词之间用一个或多个空格”"隔开，统计该串单词中包含”e"的单词数量，"e"不区分大小写
     * 度小于等于O(n)。
     */
    public static void main(String[] args) {
        String str="Nice to meet you";
        String[] strs=str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
}
