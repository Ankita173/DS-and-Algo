package org.example.basic.practice;


//            -
//        2       3
// [* + + 3 4 5 6] level order

import org.example.datastructure.TreeNode;

public class ArithmaticTree {

    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode("-", new TreeNode("2"), new TreeNode("3"));
        System.out.println(expressionEvaluation(root));

        TreeNode<String> root1 = new TreeNode("*",
                    new TreeNode("+",
    new TreeNode("3"), new TreeNode("4")),
                                new TreeNode("+",
                        new TreeNode("5"), new TreeNode("6")));
        System.out.println(expressionEvaluation(root1));
    }

    static float expressionEvaluation(TreeNode root) {
        if (root == null)
            return 0;

        float left = expressionEvaluation(root.getLeft());
        float right = expressionEvaluation(root.getRight());
        if (root.getVal().equals("+"))
            return left + right;
        else if (root.getVal().equals("-"))
            return left - right;
        else if (root.getVal().equals("*"))
            return left * right;
        else if (root.getVal().equals("/"))
            return left / right;
        return Float.parseFloat((String)root.getVal());
    }
}
