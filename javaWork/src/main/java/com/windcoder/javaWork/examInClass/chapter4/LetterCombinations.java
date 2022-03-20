package com.windcoder.javaWork.examInClass.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)
 */
public class LetterCombinations {
    private String digits;
    private List<String> ans;
    private Map<Character,String> alphabet;
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        this.ans = new ArrayList<>();
        alphabet = new HashMap<>();
        alphabet.put('2',"abc");
        alphabet.put('3',"def");
        alphabet.put('4',"ghi");
        alphabet.put('5',"jkl");
        alphabet.put('6',"mno");
        alphabet.put('7',"pqrs");
        alphabet.put('8',"tuv");
        alphabet.put('9',"wxyz");
        if (digits==null||digits.equals("")) {
            return ans;
        }
        dfs(0,"");
        return  ans;
    }

    /**
     *
     * @param index
     * @param str 状态一般作为参数，有时候若想优化，可以存为共享变量，每次循环中先入栈，dfs之后出栈 从而还原现场。
     */
    private void dfs(int index,String str) {
        if(index == digits.length()) {
            ans.add(str);
            return ;
        }
        for(Character ch : alphabet.get(digits.charAt(index)).toCharArray()) {
            dfs(index+1,str+ch);
        }
    }

    public static void main(String[] args) {
        LetterCombinations a = new LetterCombinations();
        a.letterCombinations("23");
    }
}
