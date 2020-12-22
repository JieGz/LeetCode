package com.learn.array;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length > 1) {
            int len = 0;
            int element = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (element == nums[i]) {

                }
            }
        }
        return nums.length;
    }

    private void print(int[] nums, int len) {
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        final RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(nums));
        removeDuplicates.print(nums, removeDuplicates.removeDuplicates(nums));

        nums = new int[]{0};
        System.out.println(removeDuplicates.removeDuplicates(nums));
        removeDuplicates.print(nums, removeDuplicates.removeDuplicates(nums));

        nums = new int[]{0, 0, 0};
        System.out.println(removeDuplicates.removeDuplicates(nums));
        removeDuplicates.print(nums, removeDuplicates.removeDuplicates(nums));

        nums = new int[]{0, 0, 1};
        System.out.println(removeDuplicates.removeDuplicates(nums));
        removeDuplicates.print(nums, removeDuplicates.removeDuplicates(nums));

        nums = new int[]{0, 0, 1, 1};
        System.out.println(removeDuplicates.removeDuplicates(nums));
        removeDuplicates.print(nums, removeDuplicates.removeDuplicates(nums));

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates.removeDuplicates(nums));
        removeDuplicates.print(nums, removeDuplicates.removeDuplicates(nums));
    }
}
