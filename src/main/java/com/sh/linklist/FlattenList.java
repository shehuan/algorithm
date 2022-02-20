package com.sh.linklist;

/**
 * 在一个多级双向链表中节点除了有两个指针分别指向前后两个节点之外，
 * 还有一个指针指向它的子链表，并且子链表也是一个双向链表，它的节点也有指向子链表的指针。
 * 请将这样的多级双向链表展平成普通的双向链表，即所有节点都没有子链表。
 */
public class FlattenList {
    public Node2 flatten(Node2 head) {
        doFlatten(head);
        return head;
    }

    /**
     * 使用递归的方式，计算每一个子链表的头尾节点，将其插入到上一级链表中
     *
     * @param head
     * @return
     */
    public Node2 doFlatten(Node2 head) {
        Node2 curNode = head;
        Node2 tail = null;
        // 从第一级链表的头节点开始遍历
        while (curNode != null) {
            // 保存当前节点的下一个节点
            Node2 next = curNode.next;
            if (curNode.child != null) {// 当前节点有子链表
                // 获得子链表的头节点
                Node2 child = curNode.child;
                // 开始递归，计算子链表的尾节点
                Node2 childTail = doFlatten(child);
                // 以下是将子链表插入到上一级链表中
                curNode.next = child;
                child.prev = curNode;
                curNode.child = null;
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }
            }

            if (curNode.next == null) {
                tail = curNode;
            }

            // 移动到下一个节点
            curNode = next;
        }
        return tail;
    }

    public static void main(String[] args) {
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        Node2 node4 = new Node2(4);
        Node2 node5 = new Node2(5);
        Node2 node6 = new Node2(6);
        Node2 node7 = new Node2(7);
        Node2 node8 = new Node2(8);
        Node2 node9 = new Node2(9);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node2.child = node5;
        node5.next = node6;
        node6.prev = node5;
        node6.next = node7;
        node7.prev = node6;
        node6.child = node8;
        node8.next = node9;
        node9.prev = node8;
        Node2 head = new FlattenList().flatten(node1);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
