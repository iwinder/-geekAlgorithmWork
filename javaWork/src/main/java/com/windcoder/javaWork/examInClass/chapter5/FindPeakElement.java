package com.windcoder.javaWork.examInClass.chapter5;

/**
 * [162. 寻找峰值](https://leetcode-cn.com/problems/find-peak-element/)
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0,right = nums.length-1;
        while(left<right){
            int lmid = (left+right)/2;
            int rmid = lmid+1;
            if(nums[lmid]<=nums[rmid]) {
                left = lmid+1;
            } else {
                right = rmid-1;
            }
        }
        return right;
    }
}
