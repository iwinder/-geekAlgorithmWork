package com.windcoder.javaWork.work.chapter5;

/**
 * [875. 爱吃香蕉的珂珂](https://leetcode-cn.com/problems/koko-eating-bananas/)
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0,right = 0;
        for (int pile:piles) {
            left = Math.min(left,pile);
            right = Math.max(right,pile);
        }
        while(left<right) {
            int mid = (left+right)/2;
            if (validate(piles,h,mid)) {
                right = mid;
            } else  {
                left = mid+1;
            }
        }
        return right;
    }

    public boolean validate(int[] piles,int n,int k) {
        int nowHor = 0;
        for (int pile:piles) {
            if (pile<=k) {
                nowHor++;
            } else {
                int count =  (int) Math.ceil(pile*1.0/k);
                nowHor+=count;
            }
        }
        return nowHor<=n;
    }
}
