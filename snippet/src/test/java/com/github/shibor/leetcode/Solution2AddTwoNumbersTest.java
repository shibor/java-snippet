package com.github.shibor.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2AddTwoNumbersTest {

    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     */
    @Test
    public void addTwoNumbers() {

        Solution2AddTwoNumbers.ListNode l1 = new Solution2AddTwoNumbers.ListNode(2);
        l1.next = new Solution2AddTwoNumbers.ListNode(4);
        l1.next.next = new Solution2AddTwoNumbers.ListNode(3);
        Solution2AddTwoNumbers.ListNode l2 = new Solution2AddTwoNumbers.ListNode(5);
        l2.next = new Solution2AddTwoNumbers.ListNode(6);
        l2.next.next = new Solution2AddTwoNumbers.ListNode(4);

        Solution2AddTwoNumbers.ListNode r = new Solution2AddTwoNumbers.ListNode(7);
        r.next = new Solution2AddTwoNumbers.ListNode(0);
        r.next.next = new Solution2AddTwoNumbers.ListNode(8);

        Solution2AddTwoNumbers.ListNode actual = new Solution2AddTwoNumbers().addTwoNumbers(l1, l2);
        Assert.assertEquals(r, actual);
    }

    /**
     * Input: (2 -> 4 ) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 5
     */
    @Test
    public void addTwoNumbers2() {

        Solution2AddTwoNumbers.ListNode l1 = new Solution2AddTwoNumbers.ListNode(2);
        l1.next = new Solution2AddTwoNumbers.ListNode(4);

        Solution2AddTwoNumbers.ListNode l2 = new Solution2AddTwoNumbers.ListNode(5);
        l2.next = new Solution2AddTwoNumbers.ListNode(6);
        l2.next.next = new Solution2AddTwoNumbers.ListNode(4);

        Solution2AddTwoNumbers.ListNode r = new Solution2AddTwoNumbers.ListNode(7);
        r.next = new Solution2AddTwoNumbers.ListNode(0);
        r.next.next = new Solution2AddTwoNumbers.ListNode(5);

        Solution2AddTwoNumbers.ListNode actual = new Solution2AddTwoNumbers().addTwoNumbers(l1, l2);
        Assert.assertEquals(r, actual);
    }


}