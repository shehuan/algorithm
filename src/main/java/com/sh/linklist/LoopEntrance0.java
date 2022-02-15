package com.sh.linklist;

/**
 * 一个链表中包含环，如何找出环的入口结点？
 * 从链表的头结点开始沿着next指针进入环的第一个结点为环的入口节点。
 * 例如，在图4.3的链表中，环的入口结点是结点3。
 */
public class LoopEntrance0 {

    /**
     * 定义一个快指针（每次走两步）、一个慢指针（每次走一步），从头节点出发，
     * 如果链表中包含环，则快指针会绕一圈追上慢指针，返回相遇的节点
     */
    private Node getNodeInLoop(Node head) {
        // 保证至少两个节点
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
//        while (slow != null && fast != null) {
//            // 两个指针相遇
//            if (slow == fast) {
//                return slow;
//            }
//            // 慢指针走一步
//            slow = slow.next;
//            // 快指针走一步
//            fast = fast.next;
//            if (fast != null) {
//                // 快指针走第二步
//                fast = fast.next;
//            }
//        }
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
     * 上边方法返回了环中相遇的节点，从相遇的节点开始走一圈就能得到环中节点的数目。
     * 定义一个快指针、一个慢指针，分别指向表头，快指针先移动环的节点数，
     * 然后两个指针同时移动，直到相遇的节点就是环的入口节点
     */
    public Node getEntranceNode(Node head) {
        Node node = getNodeInLoop(head);
        if (node == null) {
            return null;
        }
        // 上边方法返回的节点就算一个
        int loopCount = 1;
        // 计算环中节点总数
        for (Node n = node; n.next != node; n = n.next) {
            loopCount++;
        }
        Node fast = head;
        // 快指针移动环的节点数
        for (int i = 0; i < loopCount; i++) {
            fast = fast.next;
        }
        Node slow = head;
        // 两个指针同时移动，直至相遇
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
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
        Node node = new LoopEntrance0().getEntranceNode(node1);
        System.out.println(node.val);
    }
}
