package 笔试.科大讯飞.第三题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     *
     * 通用能力测试38,19个题
     * 专业方向12,6个题
     * 50，3个题
     * 给两个数组，长度为n，且这两个数组都包含了数字1-n，不一定有序
     * 求两个数组共有的子数组个数
     * 输入示例：
     * 3
     * 1 2 3
     * 2 3 1
     * 输出：8
     * 解释：有八个公共子数组：[1],[2],[3],[1,2],[2,3],[3,1],[1,2,3],[2,3,1]
     *
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len=input.nextInt();
        int[] nums1=new int[len];
        int[] nums2=new int[len];
        for (int i = 0; i < len; i++)
           nums1[i]=input.nextInt();
        for (int i = 0; i < len; i++)
            nums2[i]=input.nextInt();

        System.out.println(solve3(len,nums1,nums2));
        input.close();
    }

    /**
     * @param len 数组长度
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    public static int solve1(int len,int[] nums1,int[] nums2){
        HashSet<List<Integer>> set=new HashSet<>();//存储所有的子数组
        for (int i = 1; i <= nums1.length; i++) {//对所有的长度
            //将子数组加入set中去
            for (int j = 0; j < nums1.length; j++) {//数组从前往后扫描
                //拿到子数组
                List<Integer> subNums=new ArrayList<>();
                for (int k = j; (k<j+i)&&(k<nums1.length); k++) {//从前到后扫描,k为尾指针
                    subNums.add(nums1[k]);
                }
                //子数组放到set中去
                set.add(subNums);
            }
        }
        for (int i = 1; i <= nums2.length; i++) {//对所有的长度
            //将子数组加入set中去
            for (int j = 0; j < nums2.length; j++) {//数组从前往后扫描
                //拿到子数组
                List<Integer> subNums=new ArrayList<>();
                for (int k = j; (k<j+i)&&(k<nums2.length); k++) {//从前到后扫描,k为尾指针
                    subNums.add(nums2[k]);
                }
                //子数组放到set中去
                set.add(subNums);
            }
        }

        return set.size();
    }//暴力，复杂度太大了，超时，通过5%

    /**
     * 相当于找两个数组共有的子数组个数
     *减少了一寸循环，但还是超时，通过10%
     * @param len 数组长度
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    public static int solve2(int len,int[] nums1,int[] nums2){
        if(len==1)
            return 1;
        else if (len==2) {
            if(nums1[0]==nums2[0]){
                return 3;
            }else
                return 4;
        }
        //用arraylist存，减少拿取子数组的时间
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for (int i = 0; i < nums1.length; i++)
            list1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++)
            list2.add(nums2[i]);

        HashSet<List<Integer>> set=new HashSet<>();//存储所有的子数组
        for (int i = 1; i <= nums1.length; i++) {//对所有的长度
            for (int j = 0; j < nums1.length; j++) {//数组从前往后扫描
                //拿到子数组
                List<Integer> subNums=new ArrayList<>();
                if(j+i<= nums1.length)
                    subNums=list1.subList(j,j+i);
                //子数组放到set中去
                if(subNums.size()!=0&&!set.contains(subNums)){
                    set.add(subNums);
                }
            }
        }
        for (int i = 1; i <= nums2.length; i++) {//对所有的长度
            for (int j = 0; j < nums2.length; j++) {//数组从前往后扫描
                //拿到子数组
                List<Integer> subNums=new ArrayList<>();
                if(j+i<= nums2.length)
                    subNums=list2.subList(j,j+i);
                //子数组放到set中去
                if(subNums.size()!=0&&!set.contains(subNums)){
                    set.add(subNums);
                }
            }
        }
        return set.size();
    }
    /**
     * 对于数组1的任意子数组，初始字符为i，
     *      从数组2中找i，并比对后面的，不一样的话res++
     * @param len 数组长度
     * @param nums1 数组1
     * @param nums2 数组2
     * @return
     */
    public static int solve3(int len,int[] nums1,int[] nums2){
        int res=0;
        //用arraylist存，减少拿取子数组的时间
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for (int i = 0; i < nums1.length; i++)
            list1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++)
            list2.add(nums2[i]);
        for (int i = 1; i <= nums1.length; i++) {//对所有的长度
            for (int j = 0; j < nums1.length; j++) {//数组从前往后扫描
                //拿到子数组
                List<Integer> subNums=new ArrayList<>();
                if(j+i<= nums1.length)
                    subNums=list1.subList(j,j+i);
                //去数组2比对
                if(subNums.size()>0){
                    int index=list2.indexOf(subNums.get(0));
                    for (int k = index; k < i; k++) {
                        if(subNums.get(k-index)!=list2.get(k))
                            break;
                        if(k==i-1)
                            res+=2;
                    }
                }
            }
        }

        return res;
    }
}
