package com.github.shibor.snippet.arithmetic.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    public static int[] sort(int[] data, int n) {
        for (int i = 1; i < n; i++) {
            int value = data[i];
            int j = i - 1;
            for (; j > -1; j--) {
                if (data[j] > value) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = value;
        }
        return data;
    }
}
