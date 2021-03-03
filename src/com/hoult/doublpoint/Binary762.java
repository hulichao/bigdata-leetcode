package com.hoult.doublpoint;

import java.util.*;

class Point {
    int data;
    int location;

    public Point(int data, int location) {
        this.data = data;
        this.location = location;
    }
}
public class Binary762 {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{0, 1}));
    }


    public static int solve(int[] nums) {
        PriorityQueue<Point> queue = new PriorityQueue<Point>((x, y) -> y.data - x.data);

        int res = 0;

        for (int l = 0; l < nums.length;l++) {
            Queue<Point> queue1 = new LinkedList<Point>();
            while (!queue.isEmpty() && queue.peek().data > nums[l] * 3) {
                res++;
                queue1.add(queue.poll());
            }

            queue.add(new Point(nums[l], l));
            while (!queue1.isEmpty()) queue.add(queue1.poll());
        }

        return res;
    }
}
