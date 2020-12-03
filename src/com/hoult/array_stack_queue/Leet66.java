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
}
