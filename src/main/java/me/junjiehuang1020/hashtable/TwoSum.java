package me.junjiehuang1020.hashtable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    public static int[] twoSum(int[] nums, int tatget) {
    
        int[] ans = new int[2];
    
        Map<Integer, Integer> table = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            if (table.containsKey(nums[i])) {
                ans[0] = table.get(nums[i]);
                ans[1] = i;
                return ans;
            }
            
            table.put(tatget - nums[i], i);
        }
        
        return ans;
    }
}
