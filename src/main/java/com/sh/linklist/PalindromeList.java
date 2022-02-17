package com.sh.linklist;

/**
 * 如何判断一个链表是不是回文？要求解法的时间复杂度是O(n)，另外不得使用超过O(1)的辅助空间。
 * 如果一个链表是回文，那么链表中结点序列从前往后看和从后往前看是相同的。
 * 例如，链表的结点序列从前往后看和从后往前看都是1、2、3、3、2、1，因此这是一个回文链表。
 */
public class PalindromeList {
    /**
     * 可以找到中间节点将链表分成两部分，将后半部分反转，然后从头逐个向后比较两个链表节点的值，有不相等的就不是回文链表
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(Node head) {
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


        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(2);
        Node node6 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        boolean palindrome = new PalindromeList().isPalindrome(node1);
        System.out.println(palindrome);
    }
}
