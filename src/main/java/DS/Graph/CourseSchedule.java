package DS.Graph;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

/*
Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course
bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
So it is impossible.

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

*/

public class CourseSchedule {
    int[][] prerequisites = null;
    public Integer numCourses = null;
    final int WHITE = 0, GRAY = 1, BLACK = 2;

    public void getInputLength(int row, int column){
        prerequisites = new int[row][column];
    }

    public void acceptInput(int num, int row, int column){
        if(row < 0 || column < 0 || row > prerequisites.length-1 || column > prerequisites[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        prerequisites[row][column] = num;
    }

    public void acceptInput(Integer numCourses) throws Exception {
        if(null == numCourses){
            throw new InvalidInputArgument(numCourses);
        }
        this.numCourses = numCourses;
    }

    public boolean canFinish() {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
        }
        int[] colors = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == WHITE && !adj[i].isEmpty() && hasCycle(adj, i, colors))
                return false;
        }
        return true;
    }

    private boolean hasCycle(List<Integer>[] adj, int node, int[] colors) {
        colors[node] = GRAY;
        for (int nei : adj[node]) {
            if (colors[nei] == GRAY) return true;
            if (colors[nei] == WHITE && hasCycle(adj, nei, colors))
                return true;
        }
        colors[node] = BLACK;
        return false;
    }
}
