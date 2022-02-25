package me.junjiehuang1020.list;

import me.junjiehuang1020.common.list.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCircle {
    
    public static boolean hasCircle(ListNode head) {
        
        Map<ListNode, Integer> map = new HashMap<>();
        
        while (head.getNext() != null) {
            
            if (map.containsKey(head)) {
                return true;
            } else {
                map.put(head, head.getVal());
                head = head.getNext();
            }
        }
        return false;
    }
}
