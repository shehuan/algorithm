package com.sh.linklist;

/**
 * 给你一个链表，请问如何删除链表中的倒数第k个结点？假设链表中结点的总数为n，那么1≤k≤n。要求只能遍历链表一次。
 * 例如输入图4.1中（a）的链表，删除倒数第2个结点之后的链表如图4.1中（b）所示。
 */
public class RemoveNthNodeFromEnd {
    public Node remove(Node head, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("要删除的节点不存在");
        }
        // dummy 为哨兵节点，在它的 next 是 head
        Node dummy = new Node(0);
        dummy.next = head;
        // 定义两个指针 front、back
        Node front = head, back = dummy;
        // 先将 front 指针向尾部移动 n 步
        for (int i = 0; i < n; i++) {
            if (front == null) {
                throw new IllegalArgumentException("要删除的节点不存在");
            }
            front = front.next;
        }
        // 此时 back 执向哨兵节点，back 和 front 之间相差 n 个节点
        // 开始同时向尾部移动两个指针
        // front 等于 null 时，即指向最后一个节点的下一个节点，此时 back 指向要删除节点的前一个节点
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        Node removedNode = back.next;
        back.next = back.next.next;
        // 返回被删除的节点
        return removedNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Node removedNode = new RemoveNthNodeFromEnd().remove(node1, 7);
        System.out.println(removedNode.val);
    }
}
