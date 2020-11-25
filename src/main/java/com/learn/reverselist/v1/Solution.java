package com.learn.reverselist.v1;

public class Solution {

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode reverseList = null;
        while (head != null) {
            final int val = head.val;
            if (reverseList != null) {
                final ListNode node = new ListNode(head.val);
                node.next = reverseList;
                reverseList = node;
            } else {
                reverseList = new ListNode(val);
            }
            head = head.next;
        }
        return reverseList;
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

    public static void main(String[] args) {
        final Solution solution = new Solution();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        final ListNode list = solution.produce(arr);
        solution.print(list);
        solution.print(solution.reverseList(list));
    }
}
