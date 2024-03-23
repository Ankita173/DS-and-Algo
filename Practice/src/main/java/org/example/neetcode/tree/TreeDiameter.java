package org.example.neetcode.tree;

import org.example.datastructure.TreeNode;

public class TreeDiameter {
    public static void main(String[] args) {
        TreeNode<Integer> t1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(diameterOfBinaryTree(t1));
    }

    static int max = 0;
    static int diameterOfBinaryTree(TreeNode<Integer> root) {
        dfs(root);
        return max;
    }

    static int dfs(TreeNode<Integer> root) {
        if(root == null) return -1;
        int leftH = 1 + dfs(root.getLeft());
        int rightH = 1 + dfs(root.getRight());
        max = max(max, leftH + rightH);
        return max(leftH, rightH);
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }
}
