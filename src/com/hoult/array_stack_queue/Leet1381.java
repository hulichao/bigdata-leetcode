package com.hoult.array_stack_queue;

/**
 * 数组模拟栈
 */
public class Leet1381 {

}
class CustomStack {
    //用数组来模拟栈
    int[] data;
    int head;
    public CustomStack(int maxSize) {
        data = new int[maxSize];
        head = -1;
    }

    public void push(int x) {
        if (head == data.length - 1)
            return;
        data[++head] = x;
    }

    public int pop() {
        if (head == -1) {
            return -1;
        }
        return data[head--];
    }

    public void increment(int k, int val) {
        for (int i=0; i< Math.min(k, head + 1); i++) {
            data[i] += val;
        }
    }
}
