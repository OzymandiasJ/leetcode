package 滑动窗口.平均数大于m的最长子序列;

public class Main {

    /**
     * 找到平均数大于m的最长连续子序列，返回其长度
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.findMaxLenWithAverageOnM(new int[]{1,12,-5,-6,50,3},10));
    }
}
class Solution {


    /**
     * 滑动窗口
     * 每个循环头指针都向前走
     * 头指针向前走，如果走一步当前窗口ave小于maxave，那么就尾指针向前走一步
     * 头指针向前走，如果走一步当前窗口ave大于maxave，那么尾指针不动，maxLen++
     * @param nums
     * @param
     * @return
     */

    public double findMaxLenWithAverageOnM(int[] nums, double m) {
        int head=0;
        int trail=0;


        double sum=0;
        int res=0;
        sum+=nums[head];
        int currLen=1;
        double maxAve=0;
        for (int i = 0; i < nums.length-1; i++) {
            head++;
            sum+=nums[head];
            currLen++;
            if(sum/currLen<=m){
                //如果走一步当前窗口ave小于maxave，说明窗口不够大，那么尾指针不动
                continue;
            }else {
                //如果走一步当前窗口ave大于maxave，说明窗口太大了，那么尾指针向前走一步
                res=currLen;
                sum-=nums[trail];
                trail++;
            }
        }
        return res;
    }

}

