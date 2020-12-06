package com.hoult.array_stack_queue;

import java.util.HashSet;
import java.util.Set;

public class Leet821 {


    //看完官方题解后，有O(N) 和 O(1)的解法
    //用一个变量记录C的最近位置，从左和从右各遍历一次即可
    public int[] shortestToChar(String S, char C) {
        //用一个变量记录C的最近位置，从左和从右各遍历一次即可

        int[] result = new int[S.length()];
        //int pre = Integer.MIN_VALUE;//这里不知的为什么过不了，看起来是越界了？
        int pre = -100000;
        for (int i = 0;i < S.length(); i++) {
            if (S.charAt(i) == C)
                pre = i;
            result[i] = i - pre;
        }

        pre = Integer.MAX_VALUE;
        for (int i = S.length() - 1; i >=0; i--) {
            if (S.charAt(i) == C)
                pre = i;

            result[i] = Math.min(pre - i, result[i]);
        }

        return result;
    }
    //O(n*n) O(N)
    public int[] shortestToChar1(String S, char C) {
        //1次遍历：没有想法，那就两次遍历
        //记住C的位置，第二次遍历时候求差值最小值
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < S.toCharArray().length;i ++){
            if (S.charAt(i) == C)
                set.add(i);
        }

        int[] result = new int[S.length()];
        for (int i = 0; i < S.toCharArray().length;i ++){
            result[i] = getMin(set, i);
        }

        return result;
    }

    //返回差值最小值
    private int getMin(Set<Integer> cs, int i) {
        int m = Integer.MAX_VALUE;
        for (Integer j : cs)
            if (Math.abs(j - i) < m)
                m = Math.abs(j - i);
        return m;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
