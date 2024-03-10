package 笔试.字符串校验;

import java.util.ArrayList;

public class Main {
    /**
     * 2021届秋招美团笔试
     * 字符串检查：
     * 1、第一个必须是大小写字母；
     * 2、只能包含字母和数字
     * 3、字母和数字分别至少有一个
     */
    public static void main(String[] args) {
        System.out.println(solution("Aadn1"));
    }
    public static boolean solution(String string) {
        // 创建一个 Character 类型的 ArrayList
        ArrayList<Character> list = new ArrayList<>();

        // 将字符串中的每个字符添加到 ArrayList 中
        for (char c : string.toCharArray()) {
            list.add(c);
        }

        //第一个必须是大小写字母；
        if(!(((list.get(0)<='z')&&('a'<=list.get(0)))||((list.get(0)<='Z')&&('A'<=list.get(0))))){
            return false;
        }
        //只能包含字母和数字
        int letterTag=0;
        int numberTag=0;
        for (int i = 1; i < list.size(); i++) {
            if(((list.get(i)<='z')&&('a'<=list.get(i)))){//字母
                letterTag=1;
            } else if (((list.get(i)<='9')&&('0'<=list.get(i)))) {//数字
                numberTag=1;
            }else {
                return false;
            }
        }
        //字母和数字分别至少有一个
        if(numberTag==0||letterTag==0)
            return false;
        else
            return true;
    }
}
