package com.fly.tools.entity;

/**
 * @author：zhangpengfei
 * @since：2022/3/17
 */
public class DoubleLink<T> {

    private Node<T> head;

    private Node<T> tail;

    private int size = 0;

    /**
     * 获取第一个节点
     *
     * @return
     */
    public Node<T> getHead() {
        return this.head;
    }

    /**
     * 获取末尾节点
     *
     * @return
     */
    public Node<T> getTail() {
        return this.tail;
    }

    /**
     * 获取链表长度
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 添加节点在尾部
     *
     * @param t
     */
    public void append(T t) {
        Node<T> node;
        if (tail == null) {
            node = new Node<>(null, null, t);
            head = node;
        } else {
            node = new Node<>(tail, null, t);
            tail.setNext(node);
        }
        tail = node;
        this.size++;
    }

    /**
     * 交换两个节点位置
     *
     * @param pre  前节点
     * @param next 后节点
     */
    public void exchange(Node<T> pre, Node<T> next) {
        if (pre.getPre() != null) {
            pre.getPre().setNext(next);
        } else {
            this.head = next;
        }
        if (next.getNext() != null) {
            next.getNext().setPre(pre);
        } else {
            this.tail = pre;
        }
        //相邻节点
        Node<T> one = next.getNext();
        Node<T> two = pre.getPre();
        if (pre.getNext().equals(next)) {
            next.setNext(pre);
            pre.setPre(next);
        } else {
            pre.getNext().setPre(next);
            next.getPre().setNext(pre);
            next.setNext(pre.getNext());
            pre.setPre(next.getPre());
        }
        pre.setNext(one);
        next.setPre(two);
    }
}
