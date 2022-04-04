package com.sh.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在完全二叉树里，除了最后一层之外其他层的节点都是满的（第n层有2n-1个节点）。最后一层的节点可能不满，该层所有的节点尽可能向左边靠拢。请实现数据结构CBTInserter的三个方法，往完全二叉树里添加节点：
 * + 构造函数CBTInserter(TreeNode root)，用一个完全二叉树的根节点初始化该数据结构。
 * + 函数CBTInserter.insert(int v)往完全二叉树里添加一个值为v的节点，并返回被插入节点的父节点。
 * + 函数CBTInserter.get_root()返回完全二叉树的根节点。
 */
public class CBTInserter<T> {
    private TreeNode<T> root;
    private Queue<TreeNode<T>> queue;

    public CBTInserter(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        // 找到没有子节点、缺少子节点的节点，栈顶的就是当前可以添加子节点的节点
        while (!queue.isEmpty() && queue.peek().left != null && queue.peek().right != null) {
            TreeNode<T> node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    public T insert(T val) {
        // 新节点
        TreeNode<T> newNode = new TreeNode<>(val);
        if (queue.isEmpty()) {
            return val;
        }
        // 新节点要添加到这个节点上
        TreeNode<T> parent = queue.peek();
        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            // 当前节点的子节点已满，将其出栈，并把子节点入栈
            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
        return parent.val;
    }

    public TreeNode<T> getRoot() {
        return root;
    }
}
