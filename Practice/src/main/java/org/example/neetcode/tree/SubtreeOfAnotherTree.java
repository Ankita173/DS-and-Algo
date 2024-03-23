package org.example.neetcode.tree;

import org.example.datastructure.TreeNode;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode<Integer> t1 = new TreeNode(1, new TreeNode(1), null);
        TreeNode<Integer> t2 = new TreeNode(1);
//        System.out.println(isSubtree(t1, t2));

        t1 = new TreeNode(-1, new TreeNode(-4, new TreeNode(-6, null, new TreeNode(-5)), new TreeNode(-2)),
                                  new TreeNode(8, new TreeNode(3, new TreeNode(0), new TreeNode(7)), new TreeNode(9)));
        t2 = new TreeNode(3, new TreeNode(0), new TreeNode(5848));
//        System.out.println(isSubtree(t1, t2));

        t1 = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        t2 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(isSubtree(t1, t2));
    }
    static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        else {
            if (root.getVal().equals(subRoot.getVal())) {
                if (isTreeSame(root, subRoot)) return true;
            }
            if (isSubtree(root.getLeft(), subRoot) ||
                    isSubtree(root.getRight(), subRoot))
                return true;
        }
        return false;
    }

    static boolean isTreeSame(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        else if (root != null && subRoot != null) {
            if (root.getVal().equals(subRoot.getVal())) {
                if (isTreeSame(root.getLeft(), subRoot.getLeft()) &&
                        isTreeSame(root.getRight(), subRoot.getRight()))
                    return true;
            }
        }
        return false;
    }
}
