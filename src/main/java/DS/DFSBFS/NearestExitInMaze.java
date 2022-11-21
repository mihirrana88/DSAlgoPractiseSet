package DS.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

/*
Nearest Exit from Entrance in Maze

You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and
walls (represented as '+'). You are also given the entrance of the maze, where
entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially
standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall,
and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance.
An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as
an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such
path exists.

Example 1:
Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.

Example 2:
Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.

Example 3:
Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.

Constraints:

maze.length == m
maze[i].length == n
1 <= m, n <= 100
maze[i][j] is either '.' or '+'.
entrance.length == 2
0 <= entrancerow < m
0 <= entrancecol < n
entrance will always be an empty cell.

*/

public class NearestExitInMaze {
    int[][] maze = null;
    public int[] entrance = null;

    public void getInputLength(int row, int column){
        maze = new int[row][column];
    }

    public void acceptInput(int num, int row, int column){
        if(row < 0 || column < 0 || row > maze.length-1 || column > maze[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        maze[row][column] = num;
    }

    public void getInputLength(int len){
        entrance = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= entrance.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        entrance[index] = num;
    }

    public int nearestExit() {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+') continue;
                    if(x == 0 || x == m - 1 || y == 0 || y == n - 1) return steps + 1;
                    q.add(new int[]{x,y});
                    maze[x][y] = '+';
                }
            }
            steps++;
        }
        return -1;
    }
}
