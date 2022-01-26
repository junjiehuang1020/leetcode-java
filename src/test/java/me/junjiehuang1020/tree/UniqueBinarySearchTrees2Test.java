package me.junjiehuang1020.tree;

import me.junjiehuang1020.common.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniqueBinarySearchTrees2Test {
    
    @Test
    void solution1() {
        List<TreeNode> treeNodes = new UniqueBinarySearchTrees2().solution1(3);
        treeNodes.forEach(BinaryTreeInorderTraversal::solution5);
    }
}
