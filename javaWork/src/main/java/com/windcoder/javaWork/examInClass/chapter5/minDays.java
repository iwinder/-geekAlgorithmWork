package com.windcoder.javaWork.examInClass.chapter5;

public class minDays {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 0,right = 0,lastBloom=0;
        for (int bloom:bloomDay) {
            lastBloom = Math.max(lastBloom,bloom);
        }
        right = lastBloom+1; // 最晚的一朵+1；
        while (left<right) {
            int mid = (left+right)/2;
            if (validateOnDay(bloomDay,m,k,mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        if (right==lastBloom+1) {
            return -1; // 当right到 最晚的+1，代表无解
        }
        return right;
    }

    /**
     *
     * @param bloomDay 第 i 朵花会在 bloomDay[i] 时盛开
     * @param m 摘 m 束花
     * @param k 需要使用相邻的 k 朵花
     * @param now 天数,在 day 此天数是否可以做出
     */
    private boolean validateOnDay(int[] bloomDay,int m,int k,int now) {
        int bouquet = 0; // 当前做的花束数量
        int consecutive = 0; // 连续的开放的数量
        for (int bloom:bloomDay) {
            if (bloom<=now) {
                consecutive++;
                if (consecutive==k) {
                    bouquet++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }
        return bouquet>=m;
    }
}
