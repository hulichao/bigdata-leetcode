package com.hoult.doublpoint;

public class Leet74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        //pos = x * n + y
        int l = 0, r = m * n - 1;
        while (l <= r) {//为什么？
            int mid = (l + r) >> 1;
            if ( target == matrix[mid / n][mid % n])
                return true;
            else if (target > matrix[mid / n][mid % n])
                l = mid + 1;
            else
                r = mid - 1;
        }

        return false;
    }
}

