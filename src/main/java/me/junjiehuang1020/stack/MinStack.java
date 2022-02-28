package me.junjiehuang1020.stack;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

class MinStack {
    
    private Deque<Integer> minStack;
    
    private Deque<Integer> stack;
    
    public MinStack() {
        
        minStack = new LinkedList<>();
        stack = new LinkedList<>();
    }
    
    public void push(int val) {
        
        stack.push(val);
    
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
        
    }
    
    public void pop() {
        
        stack.pop();
        
        minStack.pop();
    }
    
    public int top() {
        
        return stack.peek();
        
    }
    
    public int getMin() {
        
        return minStack.peek();
        
    }
}
