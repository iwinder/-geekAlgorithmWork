package com.windcoder.javaWork.work.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)
 */
public class PermuteUnique {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        // 初始化数组，记录第一次出现的位置
        vis = new boolean[nums.length];
        // 对原数组排序，保证相同的数字相邻
        Arrays.sort(nums);
        backtrack(nums,result,0,perm);
        return result;
    }

    /**
     * 填充 perm,idx
     * @param nums
     * @param result 最终结果集
     * @param idx 填充位置，当为n说明已经填充完成一个数组，所以result增加一个并返回
     * @param perm 每次的当前排列
     */
    public void backtrack(int[] nums, List<List<Integer>> result,int idx,List<Integer> perm) {
        int len = nums.length;
        if (idx == len) {
            result.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i=0;i<len;i++) {
            if (vis[i] || (i>0&&nums[i]==nums[i-1]&&!vis[i-1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums,result,idx+1,perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
