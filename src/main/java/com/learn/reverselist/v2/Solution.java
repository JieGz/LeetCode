package com.learn.reverselist.v2;

public class Solution {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    private ListNode produce(int[] arr) {
        ListNode l1 = new ListNode(0);
        ListNode l1Tail = l1;
        for (int i = 0; i < arr.length; i++) {
            l1Tail.val = arr[i];
            if (i != arr.length - 1) {
                ListNode tmp = new ListNode(0);
                l1Tail.next = tmp;
                l1Tail = tmp;
            }
        }
        return l1;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        final ListNode list = solution.produce(arr);
        solution.print(list);
        solution.print(solution.reverseList(list));
    }
}
