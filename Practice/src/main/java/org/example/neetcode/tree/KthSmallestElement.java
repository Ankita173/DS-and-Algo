package org.example.neetcode.tree;

import org.example.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    public static void main(String[] args) {
        TreeNode<Integer> t1 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println(kthSmallest(t1, 2));
    }

    static int kthSmallest(TreeNode root, int k) {
        List<Integer> inroder = new ArrayList<>();
        inorder(root, inroder);
        return inroder.get(k-1);

    }

    static void inorder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        inorder(root.getLeft(), inorder);
        inorder.add((Integer) root.getVal());
        inorder(root.getRight(), inorder);
    }
}
