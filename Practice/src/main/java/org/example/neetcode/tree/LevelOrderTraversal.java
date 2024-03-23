package org.example.neetcode.tree;

import org.example.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {



    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(3,
                new TreeNode(1,
    new TreeNode(4), new TreeNode(3)), new TreeNode(5,
                                                    new TreeNode(4), new TreeNode(6)));
        System.out.println(queueTraversal(root));
    }


    public static List<List<Integer>> queueTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> output = new ArrayList<>();
        while(!queue.isEmpty()) {
            int childs = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < childs; i++) {
                TreeNode read = queue.poll();
                level.add((Integer)read.getVal());
                if (read.getLeft() != null)
                    queue.add(read.getLeft());
                if (read.getRight() != null)
                    queue.add(read.getRight());
            }
            output.add(level);
        }

        return output;
    }


//    Another way. Not so efficient memorywise though
//    Map<Integer, List<Integer>> levelOrder = new HashMap<>();
//    public List<List<Integer>> dpTraversal(TreeNode root) {
//        levelOrder(root, 0);
//        List<List<Integer>> output = new ArrayList<>();
//        for(int i = 0; i < levelOrder.size(); i++)
//            output.add(levelOrder.get(i));
//        return output;
//    }
//
//    public void levelOrder(TreeNode root, int level) {
//        if (root == null)
//            return;
//        List<Integer> list = levelOrder.getOrDefault(level, new ArrayList<>());
//        list.add(root.val);
//        levelOrder.put(level, list);
//        levelOrder(root.left, level+1);
//        levelOrder(root.right, level+1);
//    }
}
