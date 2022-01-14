package me.junjiehuang1020.tree;

import me.junjiehuang1020.common.tree.TreeNode;
import sun.jvm.hotspot.runtime.ResultTypeFinder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    
    public static List<Integer> inorderTraversalSolutionOne(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
    
        if (root == null) {
            return result;
        }
        List<Integer> leftList = inorderTraversalSolutionOne(root.getLeft());
        result.addAll(leftList);
        result.add(root.getVal());
        List<Integer> rightList = inorderTraversalSolutionOne(root.getRight());
        result.addAll(rightList);
    
        return result;
        
    }
    
    public static List<Integer> inorderTraversalSolutionTwo(TreeNode root) {
    
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    
    private void inorder(TreeNode root, ArrayList<Integer> result) {
    
        if (root == null) {
            return;
        }
        
        inorder(root.getLeft(), result);
        result.add(root.getVal());
        inorder(root.getRight(), result);
        
    }
    
    public static List<Integer> inorderTraversalSolutionThree(TreeNode root) {
    
        List<Integer> result = new ArrayList<>();
    
        Deque<TreeNode> stack = new LinkedList<>();
    
        if (root == null) {
            return result;
        } else {
            stack.push(root);
        }
    
        while (!stack.isEmpty()) {
            while (root.getLeft() != null) {
                stack.push(root.getLeft());
                root = root.getLeft();
            }
            root = stack.pop();
            result.add(root.getVal());
            if (root.getRight() != null) {
                root = root.getRight();
            } else {
                root.setLeft(null);
            }
        }
        return result;
    }
    
    public static List<Integer> inorderTraversalSolutionFour(TreeNode root) {
    
        List<Integer> result = new ArrayList<>();
    
        while (root != null) {
            if (root.getLeft() == null) {
                System.out.println(root.getVal());
                result.add(root.getVal());
                root = root.getRight();
            } else {
                TreeNode predecessor = root.getLeft();
                // 出错点，这个算法关键在于如何判断前驱点predecessor
                while (predecessor.getRight() != null && !predecessor.getRight().equals(root)) {
                    predecessor = predecessor.getRight();
                }
                if (predecessor.getRight() == null) {
                    predecessor.setRight(root);
                    root = root.getLeft();
                } else {
                    System.out.println(root.getVal());
                    result.add(root.getVal());
                    predecessor.setRight(null);
                    root = root.getRight();
                }
            }
        }
        return result;
    
    }
    
    
    
}
