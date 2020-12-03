package com.hoult.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public void mergeSort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        //保证不溢出取start和end的中位数
        int mid = start + ((end - start) >> 1);
        //递归排序并且合并
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);

    }


    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int p = 0;
        while (p1 <= mid && p2 <= end) {
            if (arr[p1] > arr[p2]) {
                temp[p++] = arr[p2++];
            } else {
                temp[p++] = arr[p1++];
            }
        }
        while (p1 <= mid) {
            temp[p++] = arr[p1++];
        }
        while (p2 <= end) {
            temp[p++] = arr[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i + start] = temp[i];
        }
    }
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 1, 3, 7, 9, 8, 5};
        new MergeSort().mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        List list = new ArrayList();
    }

}
