package com.hoult.tree;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 层次遍历，将树存于一个List中
 */
public class Leet297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return null;
            Queue<TreeNode> queue = new LinkedList<>();
            String res = "";
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                res += poll.val;
                //关键，如果队列此时不为空，就要给list放值了
                if (poll.left != null)
                    queue.offer(poll.left);
                else if (!queue.isEmpty())
                    res += "null";
                if (poll.right != null)
                    queue.offer(poll.right);
                else if (!queue.isEmpty())
                    res += "null";

            }

            return res;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            List<Integer> list = Arrays.asList(data.split(",")).stream().map(Integer::valueOf).collect(Collectors.toList());
            if (list.size() == 0)
                return null;
            TreeNode root = new TreeNode(list.get(0));

           //重建二叉树
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode res = new TreeNode(list.get(0));
            queue.offer(res);

            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                if ("null".equals(list.get(i)))
                    n.left = null;
                else {
                    n.left = new TreeNode(list.get(i++));
                    queue.offer(n.left);
                }
                if ("null".equals(list.get(i)))
                    n.right = null;
                else {
                    n.right = new TreeNode(list.get(i++));
                    queue.offer(n.right);
                }

            }

            return res;

        }
}

class Right {
    public String serialize(TreeNode root) {      //用StringBuilder
        StringBuilder res = ser(root, new StringBuilder());
        return res.toString();
    }

    public StringBuilder ser(TreeNode root, StringBuilder str){
        if(null == root){
            str.append("null,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        str = ser(root.left, str);
        str = ser(root.right, str);
        return str;
    }

    public TreeNode deserialize(String data) {
        String[] str_word = data.split(",");
        List<String> list_word = new LinkedList<String>(Arrays.asList(str_word));
        return des(list_word);
    }

    public TreeNode des(List<String> list){
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode res = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        res.left = des(list);
        res.right = des(list);
        return res;
    }
}

