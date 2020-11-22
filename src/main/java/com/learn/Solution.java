//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 5283 👎 0

package com.learn;

public class Solution {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode();
		ListNode tail = head;
		boolean addOne = false;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				tail.val += l2.val;
				l2 = l2.next;
			} else if (l2 == null) {
				tail.val += l1.val;
				l1 = l1.next;
			} else {
				tail.val += l1.val + l2.val;
				l1 = l1.next;
				l2 = l2.next;
			}

			if (tail.val > 9) {
				tail.val = tail.val - 10;
				addOne = true;
			}

			if (l1 != null || l2 != null || addOne) {
				ListNode tmp = new ListNode(0);
				if (addOne) {
					tmp.val = 1;
					addOne = false;
				}
				tail.next = tmp;
				tail = tmp;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		int[] l1Arr = new int[]{9, 9, 9, 9, 9};
		int[] l2Arr = new int[]{9, 9, 9};

		final ListNode l1 = produce(l1Arr);
		final ListNode l2 = produce(l2Arr);
		print(l1);
		System.out.println();
		print(l2);
		System.out.println();
		print(new Solution().addTwoNumbers(l1, l2));
	}

	private static ListNode produce(int[] arr) {
		ListNode l1 = new ListNode();
		ListNode l1Tail = l1;
		for (int i = 0; i < arr.length; i++) {
			l1Tail.val = arr[i];
			if (i != arr.length - 1) {
				ListNode tmp = new ListNode();
				l1Tail.next = tmp;
				l1Tail = tmp;
			}
		}
		return l1;
	}

	private static void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
	}
}
