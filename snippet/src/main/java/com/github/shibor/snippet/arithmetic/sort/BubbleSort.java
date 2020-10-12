package com.github.shibor.snippet.arithmetic.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static int[] sort(int[] data, int n) {

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return data;
    }
}
