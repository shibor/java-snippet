package com.github.shibor.snippet.arithmetic.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BubbleSortTest {

    private static int[] dataPrepare;
    private int[] test;

    @BeforeClass
    public static void beforeClass() {
        Random random = new Random();
        random.setSeed(System.nanoTime());
        int term = Math.abs(random.nextInt(10000));
        dataPrepare = new int[term];
        for (int i = 0; i < term; i++) {
            dataPrepare[i] = random.nextInt();
        }
    }

    @Before
    public void before() {
        test = new int[dataPrepare.length];
        for (int i = 0; i < dataPrepare.length; i++) {
            test[i] = dataPrepare[i];
        }
    }

    @Test
    public void BubbleSort_sort() {
        // int[] test = {6, 5, 4, 3, 2, 3, 1, 0};

        long start = System.nanoTime();
        BubbleSort.sort(test, test.length);
        // Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 3, 4, 5, 6}, BubbleSort.sort(test, 8));
        System.out.printf("bubble    sort1 一共时间 %d 毫秒\n", (System.nanoTime() - start) / 1000000);
    }

    @Test
    public void InsertionSort_sort() {
        // int[] test = {6, 5, 4, 3, 2, 3, 1, 0};

        long start = System.nanoTime();
        InsertionSort.sort(test, test.length);
        // Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 3, 4, 5, 6}, InsertionSort.sort(test, 8));
        System.out.printf("insertion sort3 一共时间 %d 毫秒\n", (System.nanoTime() - start) / 1000000);
    }
}