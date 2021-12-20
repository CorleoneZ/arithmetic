package com.truster.linkedList;

/**
 * 带头节点的单链表的实现
 * @param <T>
 */
public class NodeList<T extends Comparable<T>> {

    //头节点，表示单链表第一个地址
    HeadNode<T> head;

    public NodeList() {
        this.head = new HeadNode<>(0, null, null);
    }

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    class HeadNode<T> extends Node<T> {
        int cnt;

        public HeadNode(int cnt, T data, Node<T> next) {
            super(data, next);
            this.cnt = cnt;
        }
    }

    //单链表头插法
    public void insertHead(T val) {
        Node<T> node = new Node<>(val, this.head.next);
        this.head.next = node;
        this.head.cnt += 1;
    }
    //尾插法
    public void tailHead(T val) {
        Node<T> node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node<>(val, null);
        this.head.cnt += 1;
    }
    //打印单链表所有元素值
    public void show() {
        Node<T> cur = this.head.next;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //获取单链表的个数
    public int size() {
        return this.head.cnt;
    }

    //单链表删除所有值是val的节点
    public void remove(T val) {
        Node<T> pre = head;
        Node<T> cur = head.next;
        while (cur != null) {
            if (cur.data == val) {
                pre.next = cur.next;
                cur = pre.next;
                this.head.cnt -= 1;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
    }
}
