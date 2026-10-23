package org.example.neetcode.tree;


import org.example.datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CreateBT {
    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 5,  6, 7};
        TreeNode<Integer> root = createFullBT(input, null, 0);
        System.out.println(root);

        Integer[] input2 = {1, null, 3, 4, 5,  null, 7};
        TreeNode<Integer> root1 = createParseBT(input2);
        System.out.println(root1);

    }

    static TreeNode<Integer> createFullBT(Integer[] input, TreeNode<Integer> root, int i) {
        if (i < input.length) {
            if (input[i] == null)
                return null;
            root = new TreeNode<>(input[i]);
            root.setLeft(createFullBT(input, root.getLeft(), 2*i + 1));
            root.setRight(createFullBT(input, root.getRight(), 2*i + 2));
        }
        return root;
    }


    static TreeNode<Integer> createParseBT(Integer[] input) {
        Queue<TreeNode<Integer>> parent = new LinkedList<>();
        int i = 0;
        TreeNode<Integer> root = new TreeNode<>(input[i++]);
        parent.add(root);
        while(i < input.length && !parent.isEmpty()) {
            TreeNode<Integer> node = parent.poll();
            TreeNode<Integer> left = input[i] == null ? null : new TreeNode<>(input[i]);
            if (left != null) {
                node.setLeft(left);
                parent.add(left);
            }
            if (++i >= input.length)
                break;
            TreeNode<Integer> right = input[i] == null ? null : new TreeNode<>(input[i]);
            if (right != null) {
                node.setRight(right);
                parent.add(right);
            }
            i++;
        }
        return root;
    }

}
