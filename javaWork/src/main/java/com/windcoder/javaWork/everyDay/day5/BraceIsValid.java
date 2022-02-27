package com.windcoder.javaWork.everyDay.day5;

import java.util.Stack;

/**
 * 20. 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
 */
public class BraceIsValid {

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c:chars) {
            if (c == '{' ||c=='['||c=='(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                } else  if (c=='}' && stack.pop()!='{') {
                    return false;
                } else if (c==']' && stack.pop()!='[') {
                    return false;
                } else if (c==')' && stack.pop()!='(') {
                    return false;
                }
            }

        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
}
