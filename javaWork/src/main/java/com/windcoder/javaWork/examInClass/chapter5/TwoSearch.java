package com.windcoder.javaWork.examInClass.chapter5;

/**
 * [704. 二分查找 - 力扣（LeetCode）](https://leetcode-cn.com/problems/binary-search/                                                                )
 */
public class TwoSearch {
    public int search(int[] nums, int target) {
        int left =0,right = nums.length-1;
        while (left<=right) {
            int mid = (left+right)/2;
            if (nums[mid]==target) {
                return mid;
            } else if (nums[mid]<target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}                            
