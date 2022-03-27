package com.windcoder.javaWork.work.chapter5;

/**
 * [1011. 在 D 天内送达包裹的能力](https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/)
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0,right = 0;
        for (int weight:weights) {
            left = Math.max(left,weight);
            right += weight;
        }
        while (left<right) {
            int mid = (left+right)/2;
            if (validate(weights,days,mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return right;

    }
    private boolean validate(int[] weights, int days,int size) {
        int box = 0;
        int count = 1;
        for (int weight :weights) {
            if (box+weight<=size) {
                box +=weight;
            } else {
                box = weight;
                count++;
            }
        }
        return count<=days;
    }
}
