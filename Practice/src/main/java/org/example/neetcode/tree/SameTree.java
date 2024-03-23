package org.example.neetcode.tree;

import org.example.datastructure.TreeNode;

public class SameTree {
    public static void main(String[] args) {
        TreeNode<Integer> t1 = new TreeNode(1, new TreeNode(1), null);
        TreeNode<Integer> t2 = new TreeNode(1);
        System.out.println(isSameTree(t1, t2));
    }

    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p != null && q != null) {
            if (p.getVal().equals(q.getVal())) {
                if (isSameTree(p.getLeft(), q.getLeft()) &&
                        isSameTree(p.getRight(), q.getRight()))
                    return true;
            }
        }
        return false;
    }
}
