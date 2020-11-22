package com.hoult.doublepoint;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表记录所有已经遍历过的数字
 */
public class Leet1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
            else
                map.put(nums[i], i);
        }

        return new int[2];
    }
}
