package com.sh.linklist;

/**
 * 输入两个单向链表，请问如何找出它们的第一个重合结点
 */
public class IntersectionNode {

    public Node getIntersectionNode(Node head1, Node head2) {
        int len1 = lengthOfList(head1);
        int len2 = lengthOfList(head2);
        // 计算两个链表长度差值
        int delta = Math.abs(len1 - len2);
        // 找出长的和短的链表
        Node longest = len1 > len2 ? head1 : head2;
        Node shortest = len1 < len2 ? head1 : head2;
        // 在长的链表从 head 开始移动 delta 步
        for (int i = 0; i < delta; i++) {
            longest = longest.next;
        }
        // 此时 longest 和 shortest 指向的节点后的节点数相同，开始同时移动两个指针，直至找到重合的节点
        while (longest != shortest) {
            longest = longest.next;
            shortest = shortest.next;
        }
        return longest;
    }

    /**
     * 计算链表长度
     *
     * @param head
     * @return
     */
    private int lengthOfList(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        // 链表1
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        // 链表2
        node7.next = node8;
        node8.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node head = new IntersectionNode().getIntersectionNode(node1, node7);
        System.out.print(head.val);
    }
}
