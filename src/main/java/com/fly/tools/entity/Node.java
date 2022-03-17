package com.fly.tools.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author：zhangpengfei
 * @since：2022/3/17
 */
@Data
@AllArgsConstructor
public class Node<T> {

    /**
     * 前置节点
     */
    private Node<T> pre;

    /**
     * 后置节点
     */
    private Node<T> next;

    /**
     * 当前节点值
     */
    private T val;
}
