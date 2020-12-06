package com.hoult.array_stack_queue;

import java.util.Stack;

/**
 * 此题非常好，正好不熟悉的块，栈和迭代/递归放一起，有几个边界要特别考虑，比如+=的顺序在取重复字符串和重复数字的时候
 */
public class Leet394 {
    //使用一个栈来存储中间结果和最终结果
    public String decodeString(String s) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) != ']')
                stack.push(s.charAt(i) + "");
            else {
                //取要重复的字符串
                String str = "";
                while (!stack.peek().equals("[")) {
                    str = stack.pop() + str;
                }
                stack.pop();

                //取要重复的次数
                String countStr = "";
                while (!stack.isEmpty() && stack.peek().charAt(0) >='0' && stack.peek().charAt(0) <='9')
                    countStr = stack.pop() + countStr;

                int count = 0;
                if (countStr.length() > 0)
                    count = Integer.valueOf(countStr);

                String temp = "";
                for (int j = 0; j < count; j++) {
                    temp += str;
                }

                stack.push(temp);
            }
        }

        //最后从栈中取出全部元素
        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }
}
