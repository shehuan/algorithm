package com.sh.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入一棵二叉树，请找出二叉树中每一层的最大值
 */
public class LargestValues1 {
    public List<Integer> largestValues(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        // 保存每一层节点的最大值
        List<Integer> result = new ArrayList<>();
        // 保存当前层的节点
        Queue<TreeNode<Integer>> current = new LinkedList<>();
        // 保存下一层的节点
        Queue<TreeNode<Integer>> next = new LinkedList<>();
        current.offer(root);
        while (!current.isEmpty()) {
            TreeNode<Integer> node = current.poll();
            max = Math.max(max, node.val);

            if (node.left != null) {
                next.offer(node.left);
            }

            if (node.right != null) {
                next.offer(node.right);
            }

            if (current.isEmpty()) {
                result.add(max);
                max = Integer.MIN_VALUE;
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

        List<Integer> result = new LargestValues0().largestValues(root);
        for (Integer val : result) {
            System.out.println(val);
        }
    }
}
