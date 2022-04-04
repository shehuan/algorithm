package com.sh.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入一棵二叉树，请找出二叉树中每一层的最大值
 */
public class LargestValues0 {
    public List<Integer> largestValues(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        // 当前层的节点数
        int current = 0;
        // 下一层的节点数
        int next = 0;
        int max = Integer.MIN_VALUE;
        // 保存每一层节点的最大值
        List<Integer> result = new ArrayList<>();
        // 保存每一层的节点
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        // 先遍历第一层，节点数默认为1
        current = 1;
        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            max = Math.max(max, node.val);
            current--;

            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }

            if (current == 0) {
                result.add(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = 0;
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
