package com.windcoder.javaWork.work.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * [1074. 元素和为目标值的子矩阵数量](https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/)
 */
public class NumSubmatrixSumTarget {
    int n,m;


    /**
     * 计算元素和为目标值的子矩阵数量
     * @param matrix
     * @param target
     * @return
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int sum[];
        int count = 0;
        for (int i=0;i<n;i++) { // 上限
            sum = new int[m];
            for (int j=i;j<n;j++) { // 下限，由于是行的下限，所以 i<= j<n
                for (int c=0;c<m;c++) { // 列
                    sum[c] +=matrix[j][c]; // 记录到j行时，每一c列的和，从而转换成前n列的
                }
                //
                count +=subarraySum(sum,target); // 转换为计算子项前缀和符合的次数
            }
        }
        return count;
    }

    public int subarraySum(int[] nums, int k) {
        int pre=0,len =nums.length,count=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0;i<len;i++) {
            pre+=nums[i];
            if (map.containsKey(pre-k)) {
                count += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }







    public static void main(String[] args) {
        int[][] anum = {{1,-1},{-1,1}};
        NumSubmatrixSumTarget target = new NumSubmatrixSumTarget();
        System.out.println(target.numSubmatrixSumTarget(anum,0));
    }

}
