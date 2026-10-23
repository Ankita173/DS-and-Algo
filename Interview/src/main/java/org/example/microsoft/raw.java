//package org.example.microsoft;
//
//public class raw {
//}
//
//
//
//package com.codility;
//
//// you can also use imports, for example:
//import java.util.*;
//
//
//// class Tree {
////     int value;
////     Tree left;
////     Tree right;
//
////     public Tree(int value, Tree left, Tree right) {
////         this.value = value;
////         this.left = left;
////         thi.right = right;
////     }
//
//// }
//
//
//class Node {
//    int value;
//    Node next;
//    public Node(int value) {
//        this.value = value;
//    }
//}
//
//public class Solution {
//
//    public static void main(String [] args) {
//        int[] input = {1, 2, 3, 5};
//        Node root = null;
//        Node next = root;
//        for(int i = 0; i < input.length; i++) {
//            next = new Node(input[i]);
//            root.next = next;
//        }
//
//        contiansLoop()
//    }
//
//    public static boolean contiansLoop(Node root) {
//        if (root == null || root.next == null) return false;
//        Node slow = root;
//        Node fast = root.next;
//
//        while(fast != null) {
//            if (slow == fast)
//                return true;
//
//            slow = slow.next;
//            fast = fast.next;
//            if(fast == null) return false;
//            fast = fast.next;
//        }
//        return false;
//    }
//
//
//    public static List<Integer> rightView(Tree root) {
//        List<Integer> result = new ArrayList<>();
//        if(root == null) return result;
//        Queue<Tree> traversal = new LinkedList<>();
//        traversal.add(root);
//        List<Tree> childs = new ArrayList<>();
//        while(!traversal.isEmpty()) {
//            Tree lookup = traversal.poll();
//            if (lookup.left) != null) childs.add(lookup.left);
//            if (lookup.right) != null) childs.add(lookup.right);
//            if(traversal.isEmpty()) {
//                result.add(lookup.value);
//                traversal.addAll(childs);
//                childs.clear();
//            }
//        }
//        return result;
//    }
//
//
//}
//
//
//
//// 1 2 | 2 5 | 4 2 | 5 5 - o(n)
//
//
//
//// time: o(n)
//// result = o(h) + o(b)