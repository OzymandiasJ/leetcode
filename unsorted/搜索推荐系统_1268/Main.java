package umsorted.搜索推荐系统_1268;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        List<String> products=new ArrayList<>();

        products.add("mobile");
        products.add("mouse");
        products.add("moneypot");
        products.add("monitor");
        products.add("mousepad");
        String searchWord = "mouse";

        Solution solution=new Solution();
        for (List<String> list: solution.suggestedProducts(products.toArray(new String[0]),searchWord)) {
            System.out.println(list);
        }
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> lists=new ArrayList<>();
        //建树
        Trie trie=new Trie();
        for (int i = 0; i < products.length; i++) {
            trie.insert(products[i]);
        }
        //查询
        for (int i = 1; i <= searchWord.length(); i++) {
            List<String> list= new ArrayList<>();
            list=trie.prefixString(searchWord.substring(0,i));
            //只要前三个
            List<String> new_list= new ArrayList<>();
            int count=list.size()>3?3:list.size();
            for (int j = 0; j < count; j++)
                new_list.add(list.get(j));
            lists.add(new_list);
        }

        return lists;
    }
}
class Trie {//前缀树
    class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
        p.end = true;
    }

    public boolean search(String s) {//检查该字符串是否在字符串数据集中
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return p.end;
    }

    public boolean startsWith(String s) {//检验s是否是字符串集的前缀
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return true;
    }
    public List<String> prefixString(String s) {
        TrieNode p = root;
        List<String> list = new ArrayList<>();

        //如果searchword的首字母都不是所有字符串集的前缀，就没必要查询了,直接返回空集
        if(p.tns[s.charAt(0)-'a']==null)
            return list;
        // 定位到前缀的最后一个字符所在的节点
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) {
                break; // 如果前缀不存在，则返回空数组
            }
            p = p.tns[u];
        }
        // 接着返回以该节点为根的子树中所有字符串
        dfs(p, new StringBuilder(s), list);
        return list;
    }

    //dfs回溯
    private void dfs(TrieNode node, StringBuilder prefix, List<String> list) {
        if (node.end) {
            list.add(prefix.toString()); // 如果节点是字符串的末尾，将其加入结果列表
        }
        for (int i = 0; i < 26; i++) {
            if (node.tns[i] != null) {
                char c = (char) ('a' + i);
                prefix.append(c); // 将当前字符添加到前缀中
                dfs(node.tns[i], prefix, list); // 递归遍历子节点
                prefix.deleteCharAt(prefix.length() - 1); // 回溯，删除添加的字符
            }
        }
    }
}
