package com.sh.linklist;

/**
 * 给你两个表示非负整数的单向链表，请问如何实现这两个整数的相加并且把和仍然用单向链表表示？
 * 链表中的每个结点表示整数十进制的一位，并且头结点对应整数的最高位数而尾结点对应整数的个位数。
 * 例如在图4.10（a）和（b）中的两个链表分别表示整数723和531，它们的和为654, 984+18=1002
 */
public class AddTwoList {
    public Node add(Node head1, Node head2) {
        ReverseList reverseList = new ReverseList();
        // 由于低位在链表尾部，需要将两个链表反转，这样可以从表头开始逐位相加
        head1 = reverseList.reverse(head1);
        head2 = reverseList.reverse(head2);
        // 定义一个哨兵节点，指向和链表的表头
        Node dummy = new Node(0);
        // 记录两个链表对应节点的和
        Node sumNode = dummy;
        // 进位
        int carry = 0;
        while (head1 != null || head2 != null) {
            // 计算两个节点、以及上次进位值的总和
            int sum = (head1 != null ? head1.val : 0) + (head2 != null ? head2.val : 0) + carry;
            // 计算产生的进位值
            carry = sum >= 10 ? 1 : 0;
            // 计算进位后剩余的和
            sum = sum - carry * 10;
            // 封装成新节点
            sumNode.next = new Node(sum);
            sumNode = sumNode.next;

            head1 = head1 != null ? head1.next : null;
            head2 = head2 != null ? head2.next : null;
        }
        // 处理最后一次相加产生的进位值
        if (carry > 0) {
            sumNode.next = new Node(carry);
        }
        // 链表反转后返回
        return reverseList.reverse(dummy.next);
    }

    public static void main(String[] args) {
        Node node1 = new Node(9);
        Node node2 = new Node(8);
        Node node3 = new Node(4);
        node1.next = node2;
        node2.next = node3;

        Node node4 = new Node(1);
        Node node5 = new Node(8);
        Node node6 = new Node(1);
        node4.next = node5;
//        node5.next = node6;

        Node head = new AddTwoList().add(node1, node4);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
