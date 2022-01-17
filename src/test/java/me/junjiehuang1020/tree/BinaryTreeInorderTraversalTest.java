package me.junjiehuang1020.tree;

import me.junjiehuang1020.common.tree.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeInorderTraversalTest {
    
    private static TreeNode root;
    
    @BeforeAll
    static void initAll() {
        
        root = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);
        TreeNode node_6 = new TreeNode(6);
        //TreeNode node_6 = new TreeNode(7);
        node_2.setLeft(node_4);
        node_2.setRight(node_5);
        //node_5.setRight(node_6);
        node_3.setLeft(node_6);
        root.setLeft(node_2);
        root.setRight(node_3);
    }
    
    @BeforeEach
    void setUp() {
    }
    
    @Test
    void inorderTraversalSolutionFour() {
        BinaryTreeInorderTraversal.solution4(root);
    }
    
    @Test
    void solution5() {
        BinaryTreeInorderTraversal.solution5(root);
    }
}
