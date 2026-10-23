package org.example.neetcode.tree;

import org.example.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    static Integer k1, ans;
    public static void main(String[] args) {
        TreeNode<Integer> t1 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        int k = 1;
        print(kthSmallest3(t1, k)); // optimized, uses inorder trarversal with global counter
        print(kthSmallest2(t1, k)); // uses inorder trarversal with extra list size (N)
        print(kthSmallest1(t1, k)); // uses inorder trarversal with extra list size (K)
    }

    private static void print(int t1) {
        System.out.println(t1);
    }

    public static int kthSmallest3(TreeNode root, int k) {
        k1 = k;
        inorder(root);
        return ans;
    }

    private static void inorder(TreeNode<Integer> root){
        if (root == null) return;
        inorder(root.getLeft());
        if (--k1 == 0) ans = root.getVal();
        inorder(root.getRight());
    }

    static int kthSmallest1(TreeNode<Integer> root, int k) {
        List<Integer> inorder1 = new ArrayList<>();
        inorder(root, inorder1, k);
        return inorder1.get(inorder1.size()-1);
    }

    static void inorder(TreeNode root, List<Integer> inorder, int k) {
        if (root == null) return;
        inorder(root.getLeft(), inorder, k);
        if (inorder.size() == k) return;
        inorder.add((Integer) root.getVal());
        inorder(root.getRight(), inorder, k);
    }

    static int kthSmallest2(TreeNode root, int k) {
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
