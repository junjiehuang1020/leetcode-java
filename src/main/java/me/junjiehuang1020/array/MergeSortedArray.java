package me.junjiehuang1020.array;

public class MergeSortedArray {
    
    public static void solution1(int[] nums1, int m, int[] nums2, int n) {
        
        int[] nums3 = new int[m];
        
        System.arraycopy(nums1, 0, nums3, 0, m);
        
        int i = 0;
        
        int j = 0;
        
        int k = 0;
    
        while (i < m && j < n) {
            
            if (nums3[i] <= nums2[j]) {
                nums1[k] = nums3[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            
            k++;
            
        }
    
        if (i == m) {
            System.arraycopy(nums2, j, nums1, k, m + n - k);
        } else {
            System.arraycopy(nums3, i, nums1, k, m + n - k);
        }
        
    }
}
