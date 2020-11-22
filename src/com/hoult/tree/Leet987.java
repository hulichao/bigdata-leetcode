package com.hoult.tree;

import java.util.*;

/**
 * 1.先标记坐标x,y
 * 2.每个垂线上，从上到下 ，如果x,y相同则按值从小到大
 */
public class Leet987 {

    class Node implements Comparable{
        int val;
        int x;
        int y;

        Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        /**
         * x轴升序，y轴降序，相同位置不同值升序排序。
         * @param o
         * @return
         */
        @Override
        public int compareTo(Object o) {
            Node node = (Node) o;
            if(this.x == node.x){
                if(this.y == node.y){
                    return this.val - node.val;
                } else {
                    return node.y - this.y;
                }
            } else {
                return this.x - node.x;
            }
        }
    }

    private static List<Node> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        nodes.clear();
        dfs(root,0,0);
        Collections.sort(nodes);
        int preX= -2000;
        List<Integer> tmp = null;
        for(Node node: nodes){
            if(preX==node.x){
                tmp.add(node.val);
            } else {
                tmp = new ArrayList<>();
                tmp.add(node.val);
                result.add(tmp);
            }
            preX = node.x;
        }
        return result;
    }


    /**
     * 将节点按照val，x，y进行存储。
     * @param node
     * @param x
     * @param y
     */
    public void dfs(TreeNode node, int x, int y){
        if(node == null){
            return;
        }
        nodes.add(new Node(node.val,x,y));
        dfs(node.left, x-1, y-1);
        dfs(node.right, x+1, y-1);
    }
}
