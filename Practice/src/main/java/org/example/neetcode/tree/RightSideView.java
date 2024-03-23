package org.example.neetcode.tree;

import org.example.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public static void main(String[] args) {
        TreeNode<Integer> t1 = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        rightSideView(t1);
    }

    static void rightSideView(TreeNode<Integer> root) {
        if (root == null) return;
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        List<Integer> rightView = new ArrayList<>();
        levelorder(root, level, rightView);
        System.out.println(rightView);
    }

    static void levelorder(TreeNode<Integer> root, Queue<TreeNode> queue, List<Integer> rightView) {
        if (root == null) return;
        List<TreeNode> childs = new ArrayList<>();
        do {
            while (!queue.isEmpty()) {
                if (queue.size() == 1) rightView.add((int) queue.peek().getVal());
                TreeNode n = queue.poll();
                if (n.getLeft() != null) childs.add(n.getLeft());
                if (n.getRight() != null) childs.add(n.getRight());
            }
            queue.addAll(childs);
            childs.clear();
        }while(!queue.isEmpty());
    }
}
