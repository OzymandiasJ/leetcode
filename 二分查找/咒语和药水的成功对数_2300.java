package 二分查找;

import java.math.BigInteger;
import java.util.Arrays;

public class 咒语和药水的成功对数_2300 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] spells = {15,8,19};
        int[] potions= {38,36,23};
        System.out.println(solution.successfulPairs(spells,potions,328));
    }



    static class Solution {
//        public int[] successfulPairs(int[] spells, int[] potions, long success) {
//            int [] res=new int[spells.length];
//            for (int i = 0; i < spells.length; i++) {
//                int count=0;
//                for (int j = 0; j < potions.length; j++) {
//                    BigInteger mul= BigInteger.valueOf(spells[i]).multiply(BigInteger.valueOf(potions[j]));
//                    if(mul.compareTo(BigInteger.valueOf(success))>=0)
//                        count++;
//                }
//                res[i]=count;
//            }
//            return res;
//        }


        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int[] res = new int[spells.length];
            for (int i = 0; i < spells.length; i++) {
                int l = 0, r = potions.length - 1;
                int mid = 0;
                while (l <= r) {
                    mid = l + (r - l) / 2;
                    BigInteger mul = BigInteger.valueOf(spells[i]).multiply(BigInteger.valueOf(potions[mid]));
                    if (mul.compareTo(BigInteger.valueOf(success)) >= 0) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                res[i] = potions.length - l;
            }
            return res;
        }
    }
}


