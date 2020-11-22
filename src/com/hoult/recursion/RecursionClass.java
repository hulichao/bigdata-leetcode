package com.hoult.recursion;

public class RecursionClass {
    public static void main(String[] args) {
//        System.out.println(new RecursionClass().f1(10));
//        System.out.println(new RecursionClass().f2(1));
        Node t1 =new Node();t1.data=1;
        Node t2 =new Node();t2.data=2;
        Node t3 =new Node();t3.data=3;
        Node t4 =new Node();t4.data=4;
        t1.next=t2;t2.next=t3;t3.next=t4;
//        new RecursionClass().listNode(t1);
        new RecursionClass().listNode(new RecursionClass().f3(t1));
    }

    //斐波那契
    //1.定义函数
    public int f(int n) {
        //2.确定边界，退出
        if (n <= 2)
            return 1;
        //3.缩小范围到边界
        return f(n-1) + f(n-2);
    }

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    //1。定义函数
    public int f2(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return f2(n-1) + f2(n-2);
    }

    //反转单链表
    //1.定义函数
    public Node f3(Node node) {
        //2.确定返回边界
        if (node == null || node.next == null)
            return node;
        //3.拿到递归推导
        Node last = f3(node.next);
        node.next.next = node;
        node.next = null ;//这个的作用是什么?,解开死循环，最后是有A->B,B->A
        return last;
    }

    //遍历链表
    public void listNode(Node node) {
        if (node != null) {
            System.out.println(node.data);
            listNode(node.next);
        }
        else
            return;
    }

}

class Node{
    int data;
    Node next;
}

