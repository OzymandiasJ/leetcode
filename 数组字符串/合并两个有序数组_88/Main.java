package 数组字符串.合并两个有序数组_88;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int [] nums1=new int[]{1,2,3,0,0,0};
        solution.merge2(nums1,3,new int[]{2,5,6},3);
        for (int num: nums1) {
            System.out.println(num);
        }
    }
}
class Solution {
    public void merge2(int[] nums1, int m, int[] nums2, int n) {//直接sort
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < m; i++) list.add(nums1[i]);
        for (int num : nums2) list.add(num);
        Collections.sort(list);
        for (int i = 0; i < m+n; i++) nums1[i]= list.get(i);
    }
}