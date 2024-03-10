package lib;

import java.util.ArrayList;
import java.util.List;

public class Trie {//前缀树
    class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /**
     * 向前缀树中插入字符串 word 。
     * @param s
     */
    public void insert(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {//从前往后扫描字符串
            int u = s.charAt(i) - 'a';//获取当前字符的index
            if (p.tns[u] == null) //如果p.index位为空，就把该字符串到p.index上去
                p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
        p.end = true;
    }

    /**
     * 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
     * @param s
     * @return
     */
    public boolean search(String s) {//检查该字符串是否在字符串数据集中
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null)
                return false;
            p = p.tns[u];
        }
        return p.end;
    }

    /**
     * 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     * @param s
     * @return
     */
    public boolean startsWith(String s) {//检验s是否是字符串集的前缀
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return true;
    }
}
