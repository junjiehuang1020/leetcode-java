package me.junjiehuang1020.tree;

import me.junjiehuang1020.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    
    public static List<List<Integer>> solution1(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
    
        Queue<Queue<TreeNode>> queue = new LinkedList<>();
    
        // 初始化
        if (root == null) {
            return result;
        } else {
            Queue<TreeNode> innerQueue = new LinkedList<>();
            innerQueue.offer(root);
            queue.offer(innerQueue);
        }
    
        while (!queue.isEmpty()) {
        
            Queue<TreeNode> innerQueue = queue.poll();
            Queue<TreeNode> tmpQueue = new LinkedList<>();
            List<Integer> tmpList = new ArrayList<>();
            while (!innerQueue.isEmpty()) {
                TreeNode tmp = innerQueue.poll();
                if (tmp == null) {
                    continue;
                }
                tmpList.add(tmp.getVal());
                if (tmp.getLeft() != null) {
                    tmpQueue.offer(tmp.getLeft());
                }
                if (tmp.getRight() != null) {
                    tmpQueue.offer(tmp.getRight());
                }
            }
            result.add(tmpList);
            if (!tmpQueue.isEmpty()) {
                queue.offer(tmpQueue);
            }
        
        }
    
        return result;
        
    }
    
}
