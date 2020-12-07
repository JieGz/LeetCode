package com.exam;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.Arrays;

public class Solution {
    //TODO 算法排序
    public static void main(String... args){
        int[] arr = new int[]{5,7,2,9,4,1,0,5,7,11};
        //两种方式
        bubbleSort(arr,1);//冒泡排序
        quickSort(arr,0, arr.length-1,1);//快速排序
    }

    //使用的是冒泡排序
    public static int bubbleSort(int[] arr,int k) {
        //控制共比较多少轮
        for (int i = 0; i < arr.length - 1; i++) {
            //控制比较的次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        //返回第k个最大的元素
        return arr[arr.length-k];
    }


    //使用的是快速排序
    public static int quickSort(int[] arr,int start,int end,int k) {
        if (start < end) {
            //把数组中的第0个数字作为标准数
            int stard = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            while (low<high) {
                //右边的数字比标准数大
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                //使用右边的数字替换左边的数
                arr[low] = arr[high];
                //如果左边的数字比标准数小
                while (low<high&& arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            //把标准数赋给low所在的位置的元素
            arr[low] = stard;
            //处理所有的小的数字
            quickSort(arr,start,low,k);
            //处理所有的大的数字
            quickSort(arr,low+1,end,k);
        }
        return arr[arr.length-k];
    }

}
