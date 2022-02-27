package com.windcoder.javaWork.everyDay.day7;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> all = null;
    private Stack<Integer> minS = null;

    public MinStack() {
        all = new Stack<Integer>();
        minS = new Stack<Integer>();
    }

    public void push(int val) {
        all.push(val);
        if (minS.empty()) {
            minS.push(val);
        } else {
            minS.push(Math.min(minS.peek().intValue(),val));
        }

    }

    public void pop() {
        all.pop();
        minS.pop();
    }

    public int top() {
        return all.peek();
    }

    public int getMin() {
        return minS.peek();
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());
    }
}
