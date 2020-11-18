package com.hoult.tree;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用层次遍历，但是每一层从右往左遍历，即先判断右子树，再判断左子树，则最左节点是最后一个
 */
public class Leet513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //开始遍历,但是要记住当前节点
            root = queue.poll();
            if (root.right != null)
                queue.offer(root.right);
            if (root.left != null)
                queue.offer(root.left);

        }

        return root.val;
    }
}

