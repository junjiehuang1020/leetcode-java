package me.junjiehuang1020.tree;

import me.junjiehuang1020.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
    
    public List<TreeNode> solution1 (int n) {
        
        List<TreeNode> result = new ArrayList<>();
    
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                list.add(j);
            }
            TreeNode root = new TreeNode(i);
            list.set(i - 1, 0);
            generateRoot(root, list, n);
            result.add(root);
        }
        
        return result;
        
    }
    
    private void generateRoot(TreeNode root, List<Integer> list, int n) {
    
        for (int i = 1; i <= n; i++) {
            if (list.contains(i)) {
                insert(root, i);
                list.set(i - 1, 0);
                generateRoot(root, list, n);
            }
        }
        
    }
    
    private void insert(TreeNode root, int i) {
        if (root == null) {
            root = new TreeNode(i);
        } else if (i < root.getVal()) {
            if (root.getLeft() == null) {
                root.setLeft(new TreeNode(i));
            } else {
                insert(root.getLeft(), i);
            }
        } else if (i > root.getVal()) {
            if (root.getRight() == null) {
                root.setRight(new TreeNode(i));
            } else {
                insert(root.getRight(), i);
            }
        }
    }
    
}
