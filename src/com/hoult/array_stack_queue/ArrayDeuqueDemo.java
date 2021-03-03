package com.hoult.array_stack_queue;

import java.util.ArrayDeque;
import java.util.Stack;

public class ArrayDeuqueDemo {
    public static void main(String[] args) {
        ArrayDeque stack = new ArrayDeque();
        // 依次将三个元素push入“栈”，先进后出
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack); //3 2 1
        System.out.println(stack.peek()); // 3
        System.out.println(stack); // 3 2 1
        System.out.println(stack.pop()); //3
        System.out.println(stack);//2 1

        // 当做队列来使用,先进先出
        ArrayDeque queue = new ArrayDeque();

//        queue.offer("1");
//        queue.offer("2");
//        queue.offer("3");
        queue.push(4);
        queue.push(5);
        queue.push(6);
        System.out.println(queue); //1 2 3
        System.out.println(queue.peek());
        System.out.println(queue);
        // poll出第一个元素
        System.out.println(queue.poll());
        System.out.println(queue);
    }

}
