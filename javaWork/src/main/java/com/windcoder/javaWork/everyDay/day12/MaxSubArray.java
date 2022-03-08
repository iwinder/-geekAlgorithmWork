package com.windcoder.javaWork.everyDay.day12;

/**
 * [53. 最大子数组和](https://leetcode-cn.com/problems/maximum-subarray/)
 *
 */
public class MaxSubArray {
    /**
     * 两个循环，遍历所有子数组--最基础的暴力解法，耗时超大，会出现超时，不推荐
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        for (int i=0;i<len;i++) {
            int sum = 0;
            for (int j=i;j<len;j++) {
                sum+=nums[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    /**
     * 优先比较之前累加到当前的和与当前值的最大值，如果当前值大，则之前的和舍去，从当前重新计算和。
     * 比较当前数的和与最大值，记录两者最大的，一次循环遍历获得最大值。
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int len = nums.length,max=nums[0],pre=0;
        for (int n:nums) {
            pre = Math.max(pre+n,n);
            max = Math.max(pre,max);
        }
        return max;
    }

    // TODO 还有一种分治思想实现，以后补充

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
