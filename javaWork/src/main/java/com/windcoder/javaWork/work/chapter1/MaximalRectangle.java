package com.windcoder.javaWork.work.chapter1;

/**
 *  [85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/)
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        // 获取当前位置左侧连续1的数量，作为with
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (matrix[i][j]=='1') {
                    left[i][j] = (j==0?0:left[i][j-1])+1;
                }
            }
        }
        int ret = 0,area=0,with=0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                // 当前时位置是0，直接进入下一轮，仅计算为1的位置
                if (matrix[i][j]=='0') {
                    continue;
                }
                with = left[i][j];
                area = with;
                // 以当前位置为右下角，向上获取高度
                for (int k=i-1;k>=0;k--) {
                    // 出现0意味着当前列存在非连续
                    if (left[k][j]==0) {
                        break;
                    }
                    with = Math.min(with,left[k][j]);
                    area = Math.max(area,with *(i-k+1));
                }
                // 保存当前列和之前列中最大的一个
                ret = Math.max(area,ret);
            }
        }
        return ret;
    }
}
