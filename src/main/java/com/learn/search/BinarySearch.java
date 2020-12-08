package com.learn.search;

import java.util.Arrays;

public class BinarySearch {

	private int[] quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(arr, start, end);
			quickSort(arr, start, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, end);
		}
		return arr;
	}

	private int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= pivot) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] <= pivot) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = pivot;
		return left;
	}


	private int binarySearch(int[] arr, int min, int max, int target) {
		if (min <= max) {
			int mid = (min + max) >> 1;
			int midNumber = arr[mid];
			if (midNumber == target) {
				return mid;
			} else if (midNumber < target) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
			return binarySearch(arr, min, max, target);
		}
		return -1;
	}

	private int sortAndSearch(int[] arr, int target) {
		int[] sortArr = quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(sortArr));
		return binarySearch(sortArr, 0, sortArr.length - 1, target);
	}

	public static void main(String[] args) {
		int[] arr = new int[]{4, 2, 5, 7, 3, 1, 8, 9, 3};
		BinarySearch search = new BinarySearch();
		System.out.println(search.sortAndSearch(arr, 70));
	}
}
