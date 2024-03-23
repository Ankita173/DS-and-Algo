package org.example.basic.practice;

//unival tree means both child has same value Ex
//      c     |         d
//    b   b   |   null     null

import org.example.datastructure.TreeNode;
public class UnivalveBT {
    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode("a",
                new TreeNode("c",
    new TreeNode("b"), new TreeNode("b")),
                                new TreeNode("a",
                        new TreeNode("c"), new TreeNode("d")));
        System.out.println(countUnivalTree(root));
    }

    static int countUnivalTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        String left = root.getLeft() == null ? "" : (String)root.getLeft().getVal();
        String right = root.getRight() == null ? "" : (String)root.getRight().getVal();
        if (left.equals(right))
            return 1 + countUnivalTree(root.getLeft()) + countUnivalTree(root.getRight());
        return countUnivalTree(root.getLeft()) + countUnivalTree(root.getRight());
    }

}
