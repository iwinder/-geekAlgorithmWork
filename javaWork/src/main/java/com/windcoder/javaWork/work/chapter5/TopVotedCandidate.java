package com.windcoder.javaWork.work.chapter5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [911. 在线选举](https://leetcode-cn.com/problems/online-election/)
 */
public class TopVotedCandidate {
    private int[] times;
    List<Integer> tops;
    Map<Integer,Integer> cout;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        tops = new ArrayList<>();
        cout = new HashMap<>();
        cout.put(-1, -1);
        int top = -1;
        for (int i=0;i<persons.length;i++) {
            int p = persons[i];
            cout.put(p,cout.getOrDefault(p,0)+1);
            if (cout.get(p)>=cout.get(top)) {
                top = p;
            }
            // 一直保存当前领先人
            tops.add(top);
        }
    }

    public int q(int t) {
        // 二分法查询时间
        int idx = getMinIdx(t);
        return tops.get(idx);

    }

    private int getMinIdx(int t) {
        int left =0,right = times.length-1;
        while(left<right) {
            int mid = (left+right+1)/2;
            if (times[mid]<=t) { // 查找最后一个<=t的
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return right;
    }
}
