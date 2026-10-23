package org.example.neetcode.graph;

import org.example.datastructure.GraphNode;

import java.util.*;

//https://leetcode.com/problems/clone-graph/
public class CloneGraph {
    public static void main(String[] args) {
        Solution graph = new Solution();
        System.out.println(graph.cloneGraph(new GraphNode()));
    }

}

class Solution {
    Map<GraphNode, GraphNode> oldVsNew = new HashMap<>();
    public GraphNode cloneGraph(GraphNode node) {
        if (oldVsNew.containsKey(node)) return oldVsNew.get(node);
        GraphNode newNode = new GraphNode(node.val);
        oldVsNew.put(node, newNode);
        for (GraphNode n : node.neighbors) newNode.neighbors.add(cloneGraph(n));
        return newNode;
    }
}
