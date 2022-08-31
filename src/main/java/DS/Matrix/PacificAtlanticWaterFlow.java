package DS.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Pacific Atlantic Water Flow

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's
right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights
where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north,
south, east, and west if the neighboring cell's height is less than or equal to the current cell's
height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can
flow from cell (ri, ci) to both the Pacific and Atlantic oceans.



Example 1:
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
[0,4]: [0,4] -> Pacific Ocean
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

Example 2:
Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.


Constraints:

m == heights.length
n == heights[r].length
1 <= m, n <= 200
0 <= heights[r][c] <= 105

*/

public class PacificAtlanticWaterFlow {
    int[][] heights = null;

    public void getInputLength(int row, int column){
        heights = new int[row][column];
    }

    public void acceptInput(int num, int row, int column){
        if(row < 0 || column < 0 || row > heights.length-1 || column > heights[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        heights[row][column] = num;
    }

    public List<List<Integer>> pacificAtlantic() {

        int r=heights.length, c=heights[0].length;
        boolean[][] pac = new boolean[r][c];
        boolean[][] atl = new boolean[r][c];

        for (int i=0;i<c;i++){
            dfs(0,i,r,c,pac,heights[0][i],heights);
            dfs(r-1,i,r,c,atl,heights[r-1][i],heights);
        }
        for (int i=0;i<r;i++){
            dfs(i,0,r,c,pac,heights[i][0],heights);
            dfs(i,c-1,r,c,atl,heights[i][c-1],heights);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i=0;i<r;i++){
            for (int j=0; j<c;j++){
                if (pac[i][j] && atl[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j, int r, int c, boolean[][] visited, int prev, int[][] heights){
        if (i < 0 || i >= r || j < 0 || j>= c || visited[i][j] || prev > heights[i][j])
            return;
        visited[i][j]= true;
        dfs(i+1,j,r,c,visited,heights[i][j],heights);
        dfs(i-1,j,r,c,visited,heights[i][j],heights);
        dfs(i,j+1,r,c,visited,heights[i][j],heights);
        dfs(i,j-1,r,c,visited,heights[i][j],heights);
    }
}
