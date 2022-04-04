package com.sh.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 基于队列实现二叉树的广度优先搜索
 */
public class BRF<T> {
    public List<T> bfs(TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        List<T> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                result.add(node.left.val);
            }
            if (node.right != null) {
                result.add(node.right.val);
            }
        }
        return result;
    }
}
