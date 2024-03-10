package umsorted.电话号码的字母组合_17;

import java.util.*;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        String digits="234";
        Solution solution=new Solution();
        System.out.println(solution.letterCombinations(digits));
    }
}
class Solution {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits){
        List<String> combinations = new ArrayList<String>();
        if(digits.length()==0)
            return combinations;
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    /**
     * 维护一个字符串combination，表示已有的字母排列
     * 如果当前字符串索引已经==字符串长度，就把当前combination加入combinations中去
     * 否则：
     *      获取当前索引对应的数字表示的字符集
     *      遍历字符集，对每个字符c，先将c拼到combination后面，
     *      然后进行回溯：索引+1
     *      然后将先将c拼到combination后面的字符c删除，进入下一轮循环
     *
     *      返回最终的combinations即可
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if(index ==digits.length()){
            combinations.add(combination.toString());
        }else {
            char digit=digits.charAt(index);
            String letters=phoneMap.get(digit);//拿到对应的字符串，如abc
            int lettersCount=letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);//进行回退操作，遍历其余的字母排列
            }
        }
    }
}
