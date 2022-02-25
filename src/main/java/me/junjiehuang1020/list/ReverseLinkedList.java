package me.junjiehuang1020.list;

import me.junjiehuang1020.common.list.ListNode;

public class ReverseLinkedList {

    public static ListNode solution1(ListNode head){
    
        if(head == null) {
            return null;
        
        }
    
        ListNode prev = head;
        head = head.getNext();
        prev.setNext(null);
    
        while (head.getNext() != null) {
        
            ListNode node = prev;
            prev = head;
            head = head.getNext();
            prev.setNext(node);
        
        }
    
        if (head.getNext() == null) {
        
            head.setNext(prev);
        
        }
    
        return head;
    
    }
}
