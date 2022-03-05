package com.windcoder.javaWork.work.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * [697. 数组的度](https://leetcode-cn.com/problems/degree-of-an-array/)
 */
public class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> countMap = new HashMap<>(); // 记录数字及其出现次数、第一次和最后一次位置
        int minLen = 0; // 记录最小数组长度
        int num = 0;
       int  max = 0; // 用于记录度
        // 记录每个数字出现的次数、第一次出现的位置、最后一次出现的位置
        for (int i=0;i<nums.length;i++) {
            num = nums[i];
            if (countMap.containsKey(num)) {
                countMap.get(num)[0] =  countMap.get(num)[0]+1;
                countMap.get(num)[2] = i;
            } else {
                countMap.put(num,new int[]{1,i,i});
            }
        }

        // 对比获取度的最小数组长度
        for (Map.Entry<Integer,int[]> entry: countMap.entrySet()) {
            int n = entry.getValue()[0];  // 获取num的出现次数
            int v = entry.getValue()[2]-entry.getValue()[1]+1; // 获取对应数组长度
            // 如果当前出现次数小于num出现次数，或者 两者出现次数相同但数组长度大于num的数组长度，则以当前num的数组信息替换之
            if (max<n || (max==n&&minLen>v)) {
                max = n;
                minLen = v;
            }

        }
        return minLen;
    }

    public static void main(String[] args) {
       int[] nums = new int[]{1,2,2,3,1,4,2};
        FindShortestSubArray subArray = new FindShortestSubArray();
        System.out.println(subArray.findShortestSubArray(nums));
    }
}
