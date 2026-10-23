package org.example.microsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTree {

    static int max = 0;

    public static void main(String[] args) {
        Integer[] input = {0, null, 1, null, 2, 3, 4, null, 6};
        TreeNode root = TreeNode.createBT(input);
        findMaxZigzagPath1(root, 0, 0);
        System.out.println(max);
        max = 0;
        findMaxZigzagPath1(root, 0, 0);
        System.out.println(max);
        System.out.println(findMaxZigzagPath3(root));
    }

    static void findMaxZigzagPath1(TreeNode root, int left, int right) {
        if (root == null)
            return;
        max = max > left ? left : max;
        max = max < right ? right : max;
        findMaxZigzagPath1(root.left, right+1, 0);
        findMaxZigzagPath1(root.right, 0, left+1);
    }



    static void findMaxZigzagPath2(TreeNode root, int steps, boolean goLeft) {
        if (root == null)
            return;
        max = steps > max ? steps : max;
        if(goLeft) {
            findMaxZigzagPath2(root.left, steps+1, false);
            findMaxZigzagPath2(root.right, 1, true);
        } else {
            findMaxZigzagPath2(root.left, 1, false);
            findMaxZigzagPath2(root.right, steps+1, true);
        }
    }

    static int findMaxZigzagPath3(TreeNode root) {
        if (root == null)
            return 0;
        int leftDept = 1;
        if (root.left != null) {
            leftDept += findZigzagPath(root.left, 1);
        }
        int rightDept = 1;
        if (root.right != null) {
            rightDept += findZigzagPath(root.right, 0);
        }

        int max = Math.max(findMaxZigzagPath3(root.left),
        findMaxZigzagPath3(root.right));
        max = max < leftDept ? leftDept : max;
        max = max < rightDept ? rightDept : max;
        return max;
    }

    static int findZigzagPath(TreeNode root, int next) {
        if (next == 0 && root.left != null) {
            return 1 + findZigzagPath(root.left, 1);
        }

        if (next == 1 && root.right != null) {
            return 1 + findZigzagPath(root.right, 0);
        }
        return 1;
    }


}




class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    static TreeNode createBT(Integer[] input) {
        TreeNode root = new TreeNode(input[0]);
        int i = 1;
        Queue<TreeNode> parents = new LinkedList<>();
        parents.add(root);

        while (i < input.length) {
            TreeNode node = parents.poll();
            if (input[i] != null) {
                node.left = new TreeNode(input[i]);
                parents.add(node.left);
            }
            i++;
            if (i >= input.length)
                break;
            if (input[i] != null) {
                node.right = new TreeNode(input[i]);
                parents.add(node.right);
            }
            i++;
        }
        return root;
    }
}
