package com.hoult.doublpoint;

import java.util.Arrays;

public class Leet16 {
    //最接近的三数之和
    public int threeSumClosest(int[] nums, int target) {
        //1.先排序
        //2.使用一次循环 + 双指针遍历
        Arrays.sort(nums);
        int closeSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int curSum = nums[i] + nums[k] + nums[j];
                if (Math.abs(closeSum - target) > Math.abs(curSum - target))
                    closeSum = curSum;

                if (curSum > target)
                    k--;
                else if (curSum < target)
                    j++;
                else
                    return curSum;
            }
        }

        return closeSum;
    }
}
