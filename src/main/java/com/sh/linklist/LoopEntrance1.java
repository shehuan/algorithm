package com.sh.linklist;

/**
 * 一个链表中包含环，如何找出环的入口结点？
 * 从链表的头结点开始沿着next指针进入环的第一个结点为环的入口结点。
 * 例如，在图4.3的链表中，环的入口结点是结点3。
 */
public class LoopEntrance1 {

    /**
     * 定义一个快指针（每次走两步）、一个慢指针（每次走一步），从头结点出发，
     * 如果链表中包含环，则快指针会绕一圈追上慢指针，返回相遇的节点
     */
    private Node getNodeInLoop(Node head) {
        // 保证至少两个节点
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        do {
            // 慢指针走一步
            slow = slow.next;
            // 快指针走一步
            fast = fast.next;
            if (fast != null) {
                // 快指针走第二步
                fast = fast.next;
            }
            // 两个指针相遇
            if (slow == fast) {
                return slow;
            }
        } while (slow != null && fast != null);
        return null;
    }

    /**
     * 上边方法返回了环中相遇的节点
     * 让一个指针指向相遇的节点，另一个指向头节点
     * 然后两个指针同时移动，直到相遇的节点就是环的入口节点
     */
    public Node getEntranceNode(Node head) {
        Node loopNode = getNodeInLoop(head);
        if (loopNode == null) {
            return null;
        }
        Node node = head;
        // 两个指针同时移动，直至相遇
        while (node != loopNode) {
            node = node.next;
            loopNode = loopNode.next;
        }
        return node;
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
        node6.next = node3;
        Node node = new LoopEntrance1().getEntranceNode(node1);
        System.out.println(node.val);
    }
}
