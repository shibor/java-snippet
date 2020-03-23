package com.github.shibor.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution1TwoSumTest {

    Solution1TwoSum solution1TwoSum = new Solution1TwoSum();

    @Test
    public void case1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Assert.assertArrayEquals(new int[]{0,1} , solution1TwoSum.twoSum(nums, target));
    }

    @Test
    public void case2() {
        int[] nums = {3,2,4};
        int target = 6;
        Assert.assertArrayEquals(new int[]{1,2} , solution1TwoSum.twoSum(nums, target));
    }
}
