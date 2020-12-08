package com.learn.sort.v1;

public class FindNumberK {

	/**
	 * 查询数组中第k大的元素
	 *
	 * @param arr 未排序的数组
	 * @param k   第k大
	 * @return 第k大的元素
	 */
	private int findNumberK(int[] arr, int k) {
		//使用快速排序对数组进行排序
		int[] sortArr = quickSort(arr, 0, arr.length - 1);
		//返回第k大的元素
		return sortArr[sortArr.length - k];
	}

	/**
	 * 快速排序
	 *
	 * @param arr   未排序的数组
	 * @param start 排序的起始位置
	 * @param end   排序的终点位置
	 * @return 排好序的数组
	 */
	private int[] quickSort(int[] arr, int start, int end) {
		if (start < end) {
			//标准数pivot在元素中的位置
			int j = partition(arr, start, end);
			//排序左子数组
			quickSort(arr, start, j - 1);
			//排序右子数组
			quickSort(arr, j + 1, end);
		}
		return arr;
	}

	/**
	 * 查找分界点的位置
	 *
	 * @param arr   要排序的数组
	 * @param left  排序的起始位置
	 * @param right 排序的终点位置
	 * @return 分界点的位置
	 */
	private int partition(int[] arr, int left, int right) {
		//将未排序的数组的第一个元素作为标准数
		int pivot = arr[left];
		while (left < right) {
			//将右边比pivot小的数放到数组的左边
			while (left < right && arr[right] >= pivot) {
				right--;
			}
			arr[left] = arr[right];
			//将左边比pivot大的数放到数组的右边
			while (left < right && arr[left] <= pivot) {
				left++;
			}
			arr[right] = arr[left];
		}
		//将pivot放到分界点
		arr[left] = pivot;
		return left;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3, 1, 4, 5, 7, 2, 8, 2, 7};
		System.out.println(new FindNumberK().findNumberK(arr, 2));
	}
}
