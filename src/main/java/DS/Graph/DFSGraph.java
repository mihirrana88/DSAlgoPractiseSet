package DS.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSGraph {

    public List<Integer> dfsForGraphs(int numberOfNodes, List<List<Integer>> adj){
        boolean[] visited = new boolean[numberOfNodes+1];
        List<Integer> dfsList = new ArrayList<>();
        visited[0] = true;
        dfs(0, visited, adj, dfsList);
        return dfsList;
    }

    public void dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> bfsList){
        bfsList.add(node);
        visited[node] = true;
        for(int i : adj.get(node)){
            if(!visited[i]){
                dfs(i, visited, adj, bfsList);
            }
        }
    }

    public List<Integer> dfsUsingStack(int numberOfNodes, List<List<Integer>> adj){
        boolean[] visited = new boolean[numberOfNodes];
        List<Integer> dfsList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;
        while(!stack.isEmpty()){
            int node = stack.pop();
            dfsList.add(node);
            for(int i : adj.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
        return dfsList;
    }


    // Duplicate method added for practice
    public List<Integer> dfspractice(int totalNumberOfNodes, int startingNode, List<List<Integer>> adj){
        boolean[] visited = new boolean[totalNumberOfNodes];
        List<Integer> dfsList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startingNode);
        visited[startingNode] = true;
        while(!stack.isEmpty()){
            Integer node = stack.pop();
            dfsList.add(node);
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    stack.push(neighbour);
                }
            }
        }
        return dfsList;
    }

    // Duplicate method added for practice
    public List<Integer> dfsPracticeUsingRecursion(int totalNumberOfNodes, List<List<Integer>> adj){
        boolean[] visited = new boolean[totalNumberOfNodes+1];
        List<Integer> dfsList = new ArrayList<>();
        dfs2(0, visited, adj, dfsList);
        return dfsList;
    }

    // Duplicate method added for practice
    public void dfs2(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> dfsList){
        dfsList.add(node);
        if(!visited[node]){
            visited[node] = true;
            for(int neighbour : adj.get(node)){
                dfs2(neighbour, visited, adj, dfsList);
            }
        }
    }
}
