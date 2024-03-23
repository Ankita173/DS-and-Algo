package org.example.neetcode.tree;

import org.example.datastructure.TreeNode;

public class ValidateBST {

    public static void main(String[] args) {

        TreeNode<Integer> t1 = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(4)), new TreeNode(5));
        System.out.println(isValidBST(t1));
    }

    static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, null, null);
    }

    static boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if (min != null && (int)root.getVal() < min || max != null && (int)root.getVal() > max)
            return false;
        return isValidBST(root.getLeft(), min, (int)root.getVal()) && isValidBST(root.getRight(), (int)root.getVal(), max);
    }
}
