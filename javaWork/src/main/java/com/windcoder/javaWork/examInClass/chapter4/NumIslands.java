package com.windcoder.javaWork.examInClass.chapter4;

import java.util.Queue;

/**
 * [200. 岛屿数量]（https://leetcode-cn.com/problems/number-of-islands/）
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // BFS 需要定义队列
        Queue<int[][]> queue;
        // 定义方向数组
        final int[] dx={-1,0,0,1};
        final int[] dy={0,-1,1,0};
        boolean[][] visited = new boolean[m][n];
        return 0;
    }
}
