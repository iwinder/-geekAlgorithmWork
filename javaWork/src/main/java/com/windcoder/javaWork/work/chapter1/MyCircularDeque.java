package com.windcoder.javaWork.work.chapter1;

/**
 * [641. 设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/)
 */
public class MyCircularDeque {

    /**
     * 构造函数,双端队列最大为 k 。
     * @param k
     */
    public MyCircularDeque(int k) {

    }

    /**
     * 将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
     * @param value
     * @return
     */
    public boolean insertFront(int value) {
        return false;
    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
     * @param value
     * @return
     */
    public boolean insertLast(int value) {
        return false;
    }

    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
     * @return
     */
    public boolean deleteFront() {
        return false;
    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
     * @return
     */
    public boolean deleteLast() {
        return false;
    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
     * @return
     */
    public int getFront() {
        return 1;
    }

    /**
     * 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
     * @return
     */
    public int getRear() {
        return 1;
    }

    /**
     * 若双端队列为空，则返回 true ，否则返回 false  。
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * 若双端队列满了，则返回 true ，否则返回 false 。
     * @return
     */
    public boolean isFull() {
        return false;
    }
}
