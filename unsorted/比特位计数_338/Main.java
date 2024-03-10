package umsorted.比特位计数_338;

import java.util.ArrayList;

public class Main {
    /**
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
     * 计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
     */
    public static void main(String[] args) {
        Solution2 solution=new Solution2();
        System.out.println(solution.countBits(5));
    }
}
//0  --> 0
//1  --> 1
//2  --> 10
//3  --> 11
//4  --> 100
//5  --> 101
//6  --> 110
//7  --> 111
//8  --> 1000
//9  --> 1001
//10 --> 1010
//11 --> 1011
//12 --> 1100
//13 --> 1101
//14 --> 1110
//15 --> 1111

//1的个数=n%2
class Solution2 {
    //Brian Kernighan 算法
    //对于任意整数 xxx，令 x=x&(x−1)x=x~\&~(x-1)x=x&(x−1)，
    // 该运算将 xxx 的二进制表示的最后一个 111 变成 000。因此，对 xxx 重复该操作，
    // 直到 xxx 变成 000，则操作次数即为 xxx 的「一比特数」。
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}

class Solution {//暴力法
    public int[]  countBits(int n) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            int count=0;
            for (int j = 0; j < binary.length(); j++) {
                if(binary.charAt(j)=='1')
                    count++;
            }
            list.add(count);
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}