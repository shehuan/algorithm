package com.sh.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 如何在一个二叉树中找出它最底层中最左边节点的值？假设二叉树中最少有一个节点。
 */
public class BottomLeftValue<T> {
    public T find(TreeNode<T> root) {
        if (root == null) {
            return null;
        }
        // 默认根节点的值
        T leftValue = root.val;
        // 保存当前层的节点
        Queue<TreeNode<T>> current = new LinkedList<>();
        // 保存下一层的节点
        Queue<TreeNode<T>> next = new LinkedList<>();
        current.offer(root);
        while (!current.isEmpty()) {
            TreeNode<T> node = current.poll();

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (current.isEmpty()) {
                if (!next.isEmpty()) {
                    leftValue = next.peek().val;
                }
                current = next;
                next = new LinkedList<>();
            }
        }

        return leftValue;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<Integer>(3);
        TreeNode<Integer> node1 = new TreeNode<Integer>(4);
        TreeNode<Integer> node2 = new TreeNode<Integer>(2);
        TreeNode<Integer> node3 = new TreeNode<Integer>(5);
        TreeNode<Integer> node4 = new TreeNode<Integer>(1);
        TreeNode<Integer> node5 = new TreeNode<Integer>(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        BottomLeftValue<Integer> bottomLeftValue = new BottomLeftValue<>();
        Integer val = bottomLeftValue.find(root);
        System.out.println(val);
    }
}
