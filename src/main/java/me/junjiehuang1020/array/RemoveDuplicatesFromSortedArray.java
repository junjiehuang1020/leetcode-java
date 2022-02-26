package me.junjiehuang1020.array;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates1(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }
}
