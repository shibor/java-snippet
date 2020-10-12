package com.github.shibor.leetcode;

/**
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * <p>
 * Output: 7 -> 0 -> 8
 * <p>
 * Explanation: 342 + 465 = 807
 * <p>
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * <p>
 * 输出：7 -> 0 -> 8
 * <p>
 * 原因：342 + 465 = 807
 *
 * @author shibor
 */

public class Solution2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode t1 = l1, t2 = l2;
        ListNode r = new ListNode(0);
        ListNode nextNode = r;
        int n = 0;
        int temp;
        int i = 0;
        while (t1 != null || t2 != null || n != 0) {
            temp = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val) + n;
            if (i == 0) {
                r = new ListNode(temp % 10);
                nextNode = r;
            } else {
                nextNode.next = new ListNode(temp % 10);
                nextNode = nextNode.next;
            }
            n = temp / 10;

            t1 = t1 == null ? null : t1.next;
            t2 = t2 == null ? null : t2.next;
            i++;
        }

        return r;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ListNode)) {
                return false;
            }
            ListNode node = ((ListNode) obj);
            if (this.val != node.val) {
                return false;
            }
            if (this.next != null) {
                return this.next.equals(node.next);
            }
            return true;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(val);
            ListNode nextNode = this.next;
            while (nextNode != null) {
                stringBuilder.append("->");
                stringBuilder.append(nextNode.val);
                nextNode = nextNode.next;
            }
            return stringBuilder.toString();
        }
    }
}
