package com.hoult.basic;

import java.util.Arrays;

public class QuickSort {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    public void quickSort(int[] arr,int l, int r) {
        if (l >= r)
            return;

        int k = arr[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= k)
                j--;
            swap(arr, i, j);
            while (i < j && arr[i] <= k)
                i++;
            swap(arr, i, j);

        }
        quickSort(arr, l, i-1);
        quickSort(arr, j + 1, r);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 9, 1, 3, 4, 8, 7, 10};
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
