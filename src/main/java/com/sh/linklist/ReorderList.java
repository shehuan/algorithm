package com.sh.linklist;

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
        // 保存第一个链表的头节点，也就是最终新链表的头节点
        Node head = head1;
        // 定义一个临时空节点，将两个链表串起来
        Node temp = new Node(0);
        while (head1 != null && head2 != null) {
            // 先保存第一个链表当前节点的next
            Node head1Next = head1.next;

            // 第一次是空节点指向第一个链表的头节点，后续是从第二个链表的头节点开始分别指向第一个链表的后续节点
            temp.next = head1;
            // 第一个链表的第n个节点指向第二个链表的第n个节点
            head1.next = head2;
            temp = head2;

            // 两个链表头指针分别后移一步
            head1 = head1Next;
            head2 = head2.next;
        }
        // 由于第一个链表可能比第二个多一个节点，所以循环结束后第一个链表可能剩一个节点没处理
        if (head1 != null) {
            temp.next = head1;
        }
        return head;
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
