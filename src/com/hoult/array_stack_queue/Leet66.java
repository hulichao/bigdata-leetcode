package com.hoult.array_stack_queue;

import java.util.Arrays;
import java.util.List;

public class Leet66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length <=0)
            return digits;
        int pre = 0;
        for (int i=digits.length - 1; i >= 0 ;i --) {
            if (i == digits.length - 1 ) {
                digits[i] += 1;
            }
            else {
                digits[i] += pre;
                pre = 0;
            }

            if (digits[i] == 10) {
                digits[i] = 0;
                pre += 1;
            }
        }

        if (pre != 0) {
            int[] result = Arrays.copyOf(digits, digits.length + 1);
            for (int i = digits.length - 1; i >= 0; i--) {
                result[i+1] = digits[i];
            }
            result[0] = pre;
            return result;
        }

        return digits;

    }

    //写法更简单的
    public int[] plusOne2(int[] digits) {
        //想好规律在做，只有99 会变为1 0 0 也即数组被循环完，那么就好做了
        //这是特殊的加1，而不是加别的比如2，3，4
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        //全是99，上面循环结束后就都是0
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
