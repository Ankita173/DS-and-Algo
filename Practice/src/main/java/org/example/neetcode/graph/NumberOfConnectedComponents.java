package org.example.neetcode.graph;

public class NumberOfConnectedComponents {
    public static void main(String[] args) {
        int size = 4;
        int[][] edges = {{0,1},{1,2},{3,4}};
        int[][] edges1 = {{0,1},{1,2},{2, 3},{3,4}};
        int[][] edges2 = {{2, 3},{1,2},{1, 3}};

        DisjointSetUnion dsu = new DisjointSetUnion(size);

        for (int[] edge : edges2){
            if (dsu.union(edge[0], edge[1])) size--;
        }
        System.out.println(size);
    }
}

class DisjointSetUnion {
    int[] parent;
    int[] rank;
    public DisjointSetUnion(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        int cur = node;
        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }

    public boolean union(int i, int j) {
        int ip = find(i);
        int jp = find(j);
        System.out.println(ip +" "+jp);
        if (ip == jp) return false;

        if (rank[ip] < rank[jp]) {
            int temp = ip;
            ip = jp;
            jp = temp;
        }
        parent[jp] = ip;
        rank[ip] += rank[jp];
        return true;
    }
}
