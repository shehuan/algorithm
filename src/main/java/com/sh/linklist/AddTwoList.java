package com.sh.linklist;

/**
 * 给你两个表示非负整数的单向链表，请问如何实现这两个整数的相加并且把和仍然用单向链表表示？
 * 链表中的每个结点表示整数十进制的一位，并且头结点对应整数的最高位数而尾结点对应整数的个位数。
 * 例如在图4.10（a）和（b）中的两个链表分别表示整数723和531，它们的和为654
 */
public class AddTwoList {
    public Node add(Node head1, Node head2) {
        ReverseList reverseList = new ReverseList();
        // 将两个链表反转
        head1 = reverseList.reverse(head1);
        head2 = reverseList.reverse(head2);
        // 定义一个哨兵节点，指向和链表的表头
        Node dummy = new Node(0);
        // 记录两个链表对应节点的和
        Node sumNode = dummy;
        // 进位
        int carry = 0;
        while (head1 != null || head2 != null) {
            // 计算两个节点相加进位的值
            carry = head1.val + head2.val + carry > 10 ? 1 : 0;
            // 计算相加进位后剩余的值
            int sum = head1.val + head2.val - 10 * carry;
            // 封装成新节点
            sumNode.next = new Node(sum);
            sumNode = sumNode.next;

            head1 = head1.next;
            head2 = head2.next;
        }
        if (carry > 0) {
            sumNode.next = new Node(carry);
        }

        return reverseList.reverse(dummy.next);
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;

        Node node4 = new Node(5);
        Node node5 = new Node(3);
        Node node6 = new Node(1);
        node4.next = node5;
        node5.next = node6;

        Node head = new AddTwoList().add(node1, node4);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
