package com.sh.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，想象你站在该二叉树的右侧，从上到下你看到的节点构成二叉树的右侧试图。
 */
public class RightSideView {
    public List<Integer> view(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 保存当前层的节点
        Queue<TreeNode<Integer>> current = new LinkedList<>();
        // 保存下一层的节点
        Queue<TreeNode<Integer>> next = new LinkedList<>();
        current.offer(root);
        while (!current.isEmpty()) {
            TreeNode<Integer> node = current.poll();

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (current.isEmpty()) {
                // 此时node是每层最右边的节点（栈中最后出栈的）
                result.add(node.val);
                current = next;
                next = new LinkedList<>();
            }
        }

        return result;
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

        List<Integer> result = new RightSideView().view(root);
        for (Integer val : result) {
            System.out.println(val);
        }
    }
}
