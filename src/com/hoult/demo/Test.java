package com.hoult.demo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Test {
    public static void main(String[] args) {
        removeDuplicates(new int[] {1,2,3});
        Deque<Integer> deque = new ArrayDeque<Integer>();

    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;

        int m = 0, n = 0;
        for (n = 1; n < nums.length; n++) {
            if (nums[m] != nums[n]) {
                nums[++m] = nums[n++];
            }
        }

        for (int i=0;i<=m;i++) {
            System.out.println(nums[i]);
        }
        return m + 1;
    }
}
