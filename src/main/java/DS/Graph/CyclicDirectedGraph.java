package DS.Graph;

import java.util.ArrayList;

/*
Input: adj[][] = [[1], [2], [0, 3], []]
Output:  true
Explanation:  There is a cycle 0 -> 1 -> 2 -> 0.

1 ------> 2
^       / |
|     /   |
|   /     |
\/       \/
0        3


Input: adj[][] = [[2], [0], []]
1 ---> 0 ---> 2
Output:  false
Explanation:  There is no cycle in the graph.


* */

public class CyclicDirectedGraph {
    static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj,
                                int u, boolean[] visited, boolean[] recStack) {

        // Node already in recursion stack cycle found
        if (recStack[u]) return true;

        // Already processed no need to visit again
        if (visited[u]) return false;

        visited[u] = true;
        recStack[u] = true;

        // Recur for all adjacent nodes
        for (int v : adj.get(u)) {
            if (isCyclicUtil(adj, v, visited, recStack))
                return true;
        }

        // Remove from recursion stack before backtracking
        recStack[u] = false;
        return false;
    }

    // Function to detect cycle in a directed graph
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Run DFS from every unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUtil(adj, i, visited, recStack))
                return true;
        }
        return false;
    }
}
