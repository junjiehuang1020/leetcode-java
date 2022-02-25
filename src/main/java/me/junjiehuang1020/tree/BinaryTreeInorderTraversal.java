package me.junjiehuang1020.tree;

import me.junjiehuang1020.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    
    public static List<Integer> solution1(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
    
        if (root == null) {
            return result;
        }
        List<Integer> leftList = solution1(root.getLeft());
        result.addAll(leftList);
        result.add(root.getVal());
        List<Integer> rightList = solution1(root.getRight());
        result.addAll(rightList);
    
        return result;
        
    }
    
    //递归
    public static List<Integer> solution2(TreeNode root) {
    
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    
    private static void inorder(TreeNode root, ArrayList<Integer> result) {
    
        if (root == null) {
            return;
        }
        
        inorder(root.getLeft(), result);
        result.add(root.getVal());
        inorder(root.getRight(), result);
        
    }
    
    
    //迭代
    public static List<Integer> solution3(TreeNode root) {
    
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
    
    
    //Morris迭代
    public static List<Integer> solution4(TreeNode root) {
    
        List<Integer> result = new ArrayList<>();
    
        while (root != null) {
            if (root.getLeft() == null) {
                System.out.println(root.getVal());
                result.add(root.getVal());
                root = root.getRight();
            } else {
                TreeNode predecessor = root.getLeft();
                // 出错点，这个算法关键在于如何判断前驱点predecessor
                while (predecessor.getRight() != null) {
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
    
    
    public static List<Integer> solution5(TreeNode root) {
        
        class ColoredTreeNode {
            
            Boolean coloerd;
            
            TreeNode node;
    
            public ColoredTreeNode(Boolean coloerd, TreeNode node) {
                this.coloerd = coloerd;
                this.node = node;
            }
        }
        
        Deque<ColoredTreeNode> stack = new LinkedList<ColoredTreeNode>(){{
            add(new ColoredTreeNode(false, root));
        }};
    
        List<Integer> result = new ArrayList<>();
    
        while (!stack.isEmpty()) {
            ColoredTreeNode coloredTreeNode = stack.pop();
            if (coloredTreeNode.node == null) {
                continue;
            }
            if (!coloredTreeNode.coloerd) {
                stack.push(new ColoredTreeNode(false, coloredTreeNode.node.getRight()));
                stack.push(new ColoredTreeNode(true, coloredTreeNode.node));
                stack.push(new ColoredTreeNode(false, coloredTreeNode.node.getLeft()));
            } else {
                System.out.print(coloredTreeNode.node.getVal() + " ");
                result.add(coloredTreeNode.node.getVal());
            }
        }
        System.out.println("");
        return result;
    }
    
    
    
}
