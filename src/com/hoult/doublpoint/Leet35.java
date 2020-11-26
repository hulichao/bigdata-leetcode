package com.hoult.doublpoint;

public class Leet35 {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        //2分法
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                r = mid - 1;
            if (nums[mid] < target)
                l = mid + 1;
        }

        return l;
    }
}
