package org.example.neetcode.tree;

import org.example.datastructure.TreeNode;

import java.util.Arrays;

public class ContructTreeWithPreOrderInorder {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;

        TreeNode node = new TreeNode(preorder[0]);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        node.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        node.right = buildTree(rightPreorder, rightInorder);
Math.max(1, 2);
        return node;
    }
}
