package com.windcoder.javaWork.examInClass.chapter5;

/**
 * [410. 分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum/)
 */
public class SplitArray {
    public int splitArray(int[] nums, int m) {
        int left = 0,right=0;
        for (int num:nums) {
            left = Math.max(left,num);
            right +=num;
        }
        while (left<right) {
            int mid = (left+right)/2;
            if (validate(nums,mid,m)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return right;
    }

    private boolean validate(int[]nums,int size,int m) {
        int box  = 0;
        int count = 1;
        for (int num:nums) {
            if (box+num<=size) {
                box +=num;
            } else {
                count++;
                box = num;
            }
        }
        return count<=m;
    }
}
