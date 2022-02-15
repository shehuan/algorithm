package com.sh.linklist;

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 */
public class ReverseList {
    public Node reverse(Node head) {
        Node prev = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node node0 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Node head = new ReverseList().reverse(node0);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
