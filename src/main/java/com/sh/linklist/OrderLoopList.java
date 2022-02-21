package com.sh.linklist;

/**
 * 在一个循环链表中节点的值递增排序，请设计一个算法往该循环链表中插入节点，并保证插入节点之后的循环链表仍然是排序的。
 */
public class OrderLoopList {
    public Node insert(Node head, int val) {
        Node node = new Node(val);
        if (head == null) { // 原链表为空，环中没有节点
            head = node;
            head.next = head;
        } else if (head.next == head) { // 环中只有一个节点
            head.next = node;
            node.next = head;
        } else {// 环中至少两个节点
            // 从头节点开始，依次找到相邻的两个节点，如果要插入的新节点的值在两个节点之间，则将其插入两个节点之间，
            // 如果找不到这样的两个节点，则将其插入最大节点和最小节点之间
            Node cur = head;
            Node next = head.next;
            Node biggest = head;
            while (!(node.val >= cur.val && node.val <= next.val) && next != head) {
                cur = next;
                next = next.next;
                if (cur.val > biggest.val) {
                    biggest = cur;
                }
            }
            if (node.val >= cur.val && node.val <= next.val) {// 找到了相邻的两个节点
                cur.next = node;
                node.next = next;
            } else {// 插入最大节点和最小节点之间
                node.next = biggest.next;
                biggest.next = node;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
        node5.next = node6;
        node6.next = node1;
        Node head = new OrderLoopList().insert(node1, 4);
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            cur = cur.next;
            if (cur == head) {
                return;
            }
        }
    }
}
