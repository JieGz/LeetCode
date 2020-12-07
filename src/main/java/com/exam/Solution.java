package com.exam;

public class Solution {

	/**
	 * 使用快速排序法
	 *
	 * @param arr   未排序的数组
	 * @param start 排序的启始位置
	 * @param end   排序的终点位置
	 * @param k     第k个位置
	 * @return 第k大的元素
	 */
	public static int quickSort(int[] arr, int start, int end, int k) {
		if (start < end) {
			//把数组中的第0个数字作为标准数
			int begin = arr[start];
			//记录需要排序的下标
			int low = start;
			int high = end;
			//循环找比标准数大的数和比标准数小的数
			while (low < high) {
				//右边的数字比标准数大
				while (low < high && begin <= arr[high]) {
					high--;
				}
				//使用右边的数字替换左边的数
				arr[low] = arr[high];
				//如果左边的数字比标准数小
				while (low < high && arr[low] <= begin) {
					low++;
				}
				arr[high] = arr[low];
			}
			//把标准数赋给low所在的位置的元素
			arr[low] = begin;
			//处理所有的小的数字
			quickSort(arr, start, low, k);
			//处理所有的大的数字
			quickSort(arr, low + 1, end, k);
		}
		return arr[arr.length - k];
	}

	public static void main(String... args) {
		int[] arr = new int[]{2, 6, 5, 3, 6, 8, 1, 9, 9, 9, 89};
		System.out.println(quickSort(arr, 0, arr.length - 1, 1));
	}
}
