package me.junjiehuang1020.array;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArrayTest {
    
    private static int[] nums1 = new int[]{2, 0};
    
    private static int m = 1;
    
    private static int[] nums2 = new int[]{1};
    
    private static int n = 1;
    
    @BeforeAll
    static void initAll() {
    }
    
    @Test
    void solution1() {
        
        MergeSortedArray.solution1(nums1, m, nums2, n);
    }
}
