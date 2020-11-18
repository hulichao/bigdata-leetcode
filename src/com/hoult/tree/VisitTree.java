package com.hoult.tree;

import java.util.Arrays;
import java.util.LinkedList;


public class VisitTree {
    //构建二叉树，隐含了一个知识：data为null，返回的则是一个空节点
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty())
            return node;

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    //二叉树前序遍历
    public static void preOrder(TreeNode node) {
        if (node == null)
            return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    //二叉树中序遍历
    public static void inOrder(TreeNode node) {
        if (node == null)
            return;
        preOrder(node.left);
        System.out.println(node.val);
        preOrder(node.right);
    }

    //二叉树后序遍历
    public static void postOrder(TreeNode node) {
        if (node == null)
            return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));

        TreeNode node = createBinaryTree(inputList);

        //前序遍历
        System.out.println("前序遍历：");
        preOrder(node);
        //中序遍历
//        System.out.println("中序遍历：");
//        inOrder(node);
        //后序遍历
//        System.out.println("后序遍历：");
//        postOrder(node);
    }
}
