package umsorted.数组中的第K个最大元素_215;


public class test {
    /**
     * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
     *
     * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] arr = {3,2,1,5,6,4};
        int k=2;
        System.out.println(solution.findKthLargest(arr,k));
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        HeapSort heapSort=new HeapSort();
        heapSort.sort(nums);
        return nums[nums.length-k];
    }
}