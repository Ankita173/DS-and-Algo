package org.example.datastructure;
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
