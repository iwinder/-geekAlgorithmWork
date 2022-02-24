package com.windcoder.javaWork.work.chapter1;

/**
 * [641. 设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/)
 */
public class MyCircularDeque {

    class Node {
        int val;
        Node prev;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    private int size = 0;
    private int capacity = 0;
    private Node head;
    private Node tail;

    /**
     * 构造函数,双端队列最大为 k 。
     * @param k
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * 将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
     * @param value
     * @return
     */
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        Node f = head;
        Node newNode = new Node(value);
        this.head = newNode;
        if (f == null) {
            tail = head;
        } else {
            head.prev = f.prev;
            f.prev = newNode;
        }
        size++;
        return true;
    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
     * @param value
     * @return
     */
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = new Node(value);
            tail = head;
        } else {
            Node newTail = new Node(value);
            tail.next = newTail;
            newTail.prev = tail;
            newTail.next = head;
            tail = newTail;
        }
        size++;
        return true;
    }

    /**
     * 从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
     * @return
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (size==1) {
            head = null;
            tail=null;
        }
        if (size>1) {
            tail.next = head.next;
            head = head.next;
        }
        size--;

        return true;
    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
     * @return
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (size==1) {
            head = null;
            tail=null;
        }
        if (size>1) {
            tail.prev.next = head;
            tail = tail.prev;
        }
        size--;
        return true;
    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
     * @return
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        int val =  head.val;
        return val;
    }

    /**
     * 获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
     * @return
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int val = tail.val;
        return val;
    }

    /**
     * 若双端队列为空，则返回 true ，否则返回 false  。
     * @return
     */
    public boolean isEmpty() {
        if (size==0) {
            return true;
        }
        return false;
    }

    /**
     * 若双端队列满了，则返回 true ，否则返回 false 。
     * @return
     */
    public boolean isFull() {
        if (size==capacity) {
            return true;
        }
        return false;
    }
}
