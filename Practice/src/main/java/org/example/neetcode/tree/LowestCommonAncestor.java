package org.example.neetcode.tree;


import org.example.datastructure.TreeNode;

//only applicable to BST tree
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode<Integer> t1 = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(5));
        TreeNode<Integer>  t2 = new TreeNode(1);
        TreeNode<Integer>  t3 = new TreeNode(2);
        TreeNode answer = lowestCommonAncestor(t1, t2 ,t3);
        System.out.println(answer != null ? (Integer)answer.getVal() : null);
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int pVal = (Integer)p.getVal();
        int qVal = (Integer)p.getVal();
        int rootVal = (Integer)root.getVal();
        if (pVal < rootVal && qVal < rootVal) return lowestCommonAncestor(root.getLeft(), p, q);
        else if (pVal > rootVal && qVal > rootVal) return lowestCommonAncestor(root.getRight(), p, q);
        return root;
    }
}
