package com.windcoder.javaWork.work.chapter1;

/**
 * [66. 加一](https://leetcode-cn.com/problems/plus-one/)
 *
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        // 倒序遍历数组
        for(int i=len-1;i>=0;i--) {
            digits[i]++;
            // 通过取模得到0-9，0 只可能是10取模得到的
            digits[i] = digits[i]%10;
            // 当不是0，表示不需要向前进1
            if(digits[i]!=0) {
                return digits;
            }

        }
        // 处理特殊情况，当 99等临界点，需要增长数组，生成新的数组
        int[] newDigits = new int[len+1];
        newDigits[0]=1;
        return newDigits;
    }

}
