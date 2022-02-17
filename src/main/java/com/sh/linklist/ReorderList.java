package com.sh.linklist;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;

/**
 * 给你一个链表，链表中结点的顺序是L0→ L1→ L2→…→ Ln-1→ Ln，
 * 请问如何重排链表使得结点的顺序变成L0→ Ln→ L1→ Ln-1→ L2→ Ln-2→…？
 * 123456->162534
 */
public class ReorderList {
    public Node reorder(Node head) {
        // 可以找到中间节点将链表分成两部分，将后半部分反转，然后从两个链表头部开始分别取节点拼接

        // 定义一个快指针（一次走两步）一个慢指针（一次走一步），
        // 当快指针到达链表尾部时，慢指针刚好到达链表中间，此时慢指针的下一个节点就是后半部分的开始节点
        Node fast = head, slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        // head2 就是后半部分的头结点
        Node head2 = slow.next;
        // 反转链表
        head2 = new ReverseList().reverse(head2);
        // 将前半部分尾结点的next置为null，前半部分的头结点还是head
        slow.next = null;

        return reorder(head, head2);
    }

    private Node reorder(Node head1, Node head2) {
//        Node dummy = new Node(0);
//        dummy.next = head1;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Node head = new ReorderList().reorder(node1);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
