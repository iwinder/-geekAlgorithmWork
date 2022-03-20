package com.windcoder.javaWork.examInClass.chapter4;

import java.awt.font.FontRenderContext;
import java.util.*;

/**
 * [51. N 皇后]（https://leetcode-cn.com/problems/n-queens/）
 */
public class SolveNQueens {
    private int n;
    private List<List<Integer>> ans = new ArrayList<>();
    private Stack<Integer> p = new Stack<>();
    private boolean[] usd;
    // 从右上到左下方向，同一条斜线上的每个位置满足行下标与列下标之和相等，
    private Map<Integer,Boolean> usdPul =  new HashMap<>();
    // 从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等
    private Map<Integer,Boolean> usdMius =  new HashMap<>();

    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        usd = new boolean[n];
        dfs(0);
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> ap:ans) {
            for (Integer a:ap) {
                System.out.print(a+" ");
            }
            System.out.println(" ");
            List<String>  pattena = new ArrayList<>();
            for(int row=0;row<n;row++) {
                char[] r = new char[n];
                Arrays.fill(r,'.');

                r[ap.get(row)] = 'Q';

                pattena.add(new String(r));
            }
            result.add(pattena);

        }
        return result;
    }

    private void dfs(int row) {
        // 如果当前行为n,则说明到了完成一行返回
        if (row==n) {
            ans.add(new ArrayList<Integer>(p));
            return;
        }
        // 考虑当前行的列号
        for (int col =0;col<n;col++) {
            // 如果未使用过
            if (!usd[col]&&!usdPul.getOrDefault(row+col,false)&&!usdMius.getOrDefault(row-col,false)) {
                p.push(col);
                usd[col]=true;
                usdPul.put(row+col,true) ; // 对角线
                usdMius.put(row-col,true); // 对角线
                dfs(row+1);
                usd[col]=false;
                usdPul.put(row+col,false) ;
                usdMius.put(row-col,false);
                p.pop();
            }
        }
    }

    public static void main(String[] args) {
        SolveNQueens queens = new SolveNQueens();
        List<List<String>> a =queens.solveNQueens(4);

        for (List<String> b:a) {
            for (String s:b) {
                System.out.print(s+",");
            }
            System.out.println(" ");
        }
    }
}
