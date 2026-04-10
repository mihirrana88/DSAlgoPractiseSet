package DS.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {

    public List<Integer> bfsFromGivenStartingNode(int startNode, int numberOfNodes, List<List<Integer>> adj){
        boolean[] visited = new boolean[numberOfNodes];
        List<Integer> bfsList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            bfsList.add(node);
            for(int i: adj.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        return bfsList;
    }

    public List<Integer> bfs(int totalNumberOfNodes, int startingNode, List<List<Integer>> adj){
        boolean[] visited = new boolean[totalNumberOfNodes];
        List<Integer> bfslist = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingNode);
        visited[startingNode] = true;
        while (!queue.isEmpty()){
            int node = queue.poll();
            bfslist.add(node);
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        return bfslist;
    }
}
